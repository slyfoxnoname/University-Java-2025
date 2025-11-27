package HomeWorks.hm11;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeteoprogJsoupRobust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name in English (e.g., Kyiv, London, Lviv): ");
        String city = sc.nextLine().trim();

        String url = "https://www.meteoprog.ua/ua/weather/" + city + "/";

        try {
            // Завантажуємо сторінку (User-Agent потрібен)
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .timeout(15000)
                    .get();

            System.out.println("\nWeather forecast for: " + city);
            System.out.println("Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            System.out.println();

            // Шукаємо температуру — виглядає як: +3° або -1° або 3°
            Pattern tempPattern = Pattern.compile("[+-]?\\d{1,3}°"); // наприклад +3°
            Pattern humPattern = Pattern.compile("\\d{1,3}%");      // наприклад 78%

            // Зберігаємо у множини в порядку появи (щоб уникнути дублей)
            LinkedHashSet<String> temps = new LinkedHashSet<>();
            LinkedHashSet<String> hums = new LinkedHashSet<>();

            // Переберемо всі елементи сторінки — більш надійно ніж залежати від класів
            Elements all = doc.getAllElements();
            for (Element el : all) {
                String text = el.ownText(); // власний текст (без дочірніх елементів)
                if (text == null || text.isEmpty()) continue;

                // Знайдемо всі входження температур у цьому вузлі
                Matcher mTemp = tempPattern.matcher(text);
                while (mTemp.find() && temps.size() < 8) {
                    temps.add(mTemp.group());
                }

                // Знайдемо всі входження вологості у цьому вузлі
                Matcher mHum = humPattern.matcher(text);
                while (mHum.find() && hums.size() < 8) {
                    hums.add(mHum.group());
                }

                if (temps.size() >= 8 && hums.size() >= 8) break;
            }

            // Вивід температур
            System.out.println("Temperatures for today (first " + Math.min(8, temps.size()) + "):");
            if (!temps.isEmpty()) {
                int i = 1;
                for (String t : temps) {
                    System.out.println(i + ". " + t);
                    if (++i > 8) break;
                }
            } else {
                System.out.println("  (no temperature values found automatically)");
            }

            System.out.println();
            System.out.println("Humidity for today (first " + Math.min(8, hums.size()) + "):");
            if (!hums.isEmpty()) {
                int i = 1;
                for (String h : hums) {
                    System.out.println(i + ". " + h);
                    if (++i > 8) break;
                }
            } else {
                System.out.println("  (no humidity values found automatically)");
            }

            // Якщо нічого не знайдено — покажемо невеличку діагностику:
            if (temps.isEmpty() || hums.isEmpty()) {
                System.out.println("\n--- Diagnostics: snippet(s) containing ° or % ---");
                boolean shown = false;
                for (Element el : all) {
                    String txt = el.text();
                    if (txt != null && (txt.contains("°") || txt.contains("%"))) {
                        System.out.println("\nElement HTML:\n" + el.outerHtml());
                        shown = true;
                        // покажемо максимум кількох фрагментів
                        break;
                    }
                }
                if (!shown) {
                    System.out.println("No elements containing '°' or '%' were found in the fetched HTML.\n" +
                            "Possible reasons:\n" +
                            " 1) Meteoprog генерує контент динамічно через JavaScript (Jsoup отримує лише серверний HTML).\n" +
                            " 2) Адреса/місто некоректні (перевірте URL вручну у браузері).\n" +
                            " 3) Сторінка блокує запити без додаткових заголовків/куків (можна спробувати встановити реферер або інші заголовки).\n");
                } else {
                    System.out.println("\nЯкщо в snippet видно, що дані є, але Jsoup їх не знайшов — зверни увагу,\n" +
                            "що інколи значення вставляються у сторінку скриптом і можуть бути у <script> як JSON.\n" +
                            "У такому разі треба або витягти JSON зі скрипта, або використовувати браузерну автоматизацію (Selenium).\n");
                }
            }

        } catch (Exception e) {
            System.out.println("Error fetching/parsing page: " + e.getMessage());
            System.out.println("Можливі причини: неправильна назва міста, сайт блокує запити, або сторінка завантажує дані через JS.");
        }
    }
}
