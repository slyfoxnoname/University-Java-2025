package HomeWorks.hm06;

import java.io.*;
import java.util.regex.*;

public class B06_02 {
    public static void main(String[] args) {
        String inputFile = "numbers.txt";
        String outputFile = "output_06_02.txt";

        // Регулярка, що охоплює різні формати номерів
        String phoneRegex = "(\\+?\\d[\\d   \\-\\(\\) ]{5,}\\d)";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            Pattern pattern = Pattern.compile(phoneRegex);

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                
                while (matcher.find()) {
                    String phone = matcher.group().trim();
                    writer.write(phone);
                    writer.newLine();
                }
            }

            System.out.println("successfully completed!");

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}
