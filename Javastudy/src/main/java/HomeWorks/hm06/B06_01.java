package HomeWorks.hm06;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class B06_01 {
    public static void main(String[] args) {
        String inputFile = "text.txt";
        String outputfile = "output_06_01.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String today = LocalDate.now().format(formatter); // поточна дата

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // замінюємо шаблони дат на сьогоднішню дату
                line = line.replace("__.__.____", today);
                line = line.replace("DD.MM.YYYY", today);
                writer.write(line);
                writer.newLine();
                
            }   
        System.out.println("successfully completed!");
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}
