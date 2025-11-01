package HomeWorks.hm06;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class B06_03 {
    public static void main(String[] args) {
        String inputfile = "input.txt";
        String outputfile = "output_06_03.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputfile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                ArrayList<String> tokens = new ArrayList<>();
                String numberBuffer = "";

                // Разбиваем строку на токены
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (Character.isDigit(ch)) {
                        numberBuffer += ch; // копим цифры
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        if (!numberBuffer.isEmpty()) {
                            tokens.add(numberBuffer);
                            numberBuffer = "";
                        }
                        tokens.add(String.valueOf(ch)); // добавляем оператор
                    } else if (ch == ' ') {
                        // просто пропускаем пробел
                        continue;
                    } else {
                        tokens.clear(); // недопустимый символ
                        break;
                    }
                }

                // Добавляем последнее число, если есть
                if (!numberBuffer.isEmpty()) {
                    tokens.add(numberBuffer);
                }

                // Проверка корректности
                boolean correct = checkExpression(tokens);

                writer.write(line + " -> " + (correct ? "правильний" : "неправильний"));
                writer.newLine();
            }

            System.out.println("Successfully completed!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Перевірка правильності виразу
    private static boolean checkExpression(ArrayList<String> tokens) {
        if (tokens.isEmpty()) return false;

        // вираз не може починатись з оператора
        if (isOperator(tokens.get(0))) return false;

        // вираз не може закінчуватись оператором
        if (isOperator(tokens.get(tokens.size() - 1))) return false;

        // перевіряємо чергування: число → оператор → число → оператор …
        for (int i = 0; i < tokens.size() - 1; i++) {
            String current = tokens.get(i);
            String next = tokens.get(i + 1);

            if (isOperator(current) && isOperator(next)) return false;
            if (!isOperator(current) && !isOperator(next)) return false;
        }

        return true;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }
}
