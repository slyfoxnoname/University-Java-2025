package HomeWorks.hm11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCheck {
    public static void main(String[] args) {
        try {
            // 1. Запит до сайту time.is/Kyiv
            URL url = new URL("https://time.is/Kyiv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // обов'язково

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // 2. Знаходимо час у HTML (тег <time id="clock">HH:MM:SS</time>)
            String html = content.toString();
            String searchStart = "<time id=\"clock\">";
            int startIndex = html.indexOf(searchStart) + searchStart.length();
            int endIndex = html.indexOf("</time>", startIndex);

            String exactTimeStr = html.substring(startIndex, endIndex).trim();
            System.out.println("Точний час (time.is): " + exactTimeStr);

            // 3. Отримання локального часу
            LocalTime localTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String localTimeStr = localTime.format(formatter);
            System.out.println("Локальний час: " + localTimeStr);

            // 4. Порівняння
            LocalTime exactTime = LocalTime.parse(exactTimeStr, formatter);
            long differenceSeconds = Math.abs(java.time.Duration.between(localTime, exactTime).getSeconds());

            System.out.println("Рiзниця у секундах: " + differenceSeconds);

            if (differenceSeconds <= 1) {
                System.out.println("V Час на комп'ютерi вiдповiдає точному часу.");
            } else {
                System.out.println("X Час на комп'ютерii НЕ вiдповiдає точному часу.");
            }

        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}