package Aud2025.t08_Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class task2 {
    public static void main(String[] args) {
        String inputFile = "input_2.txt";

        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word.toLowerCase());
                    }
                }
            }

            System.out.println("Унiкальнi слова з файлу:");
            for (String word : uniqueWords) {
                System.out.println(word);
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
