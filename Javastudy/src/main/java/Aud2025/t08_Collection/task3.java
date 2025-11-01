package Aud2025.t08_Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) {
        String inputFile = "input_3.txt"; 

       Map<String, Integer> wordMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Слова та їх кiлькiсть:");
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("FileError: " + e.getMessage());
        }
    }
}
