package HomeWorks.hm05;

public class B05_01 {

    // Метод перевірки правильності дужок
    public static boolean checkBrackets(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                if (count > 0) return false; // вкладена дужка
                count++;
            } else if (c == ')') {
                if (count == 0) return false; // закриваюча без відкриваючої
                count--;
            }
        }
        return count == 0; // всі дужки закриті
    }

    // Метод видалення символів між дужками
    public static String removeParenthesesContent(String str) {
        StringBuilder result = new StringBuilder();
        boolean inside = false;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                inside = true;
            } else if (c == ')') {
                inside = false;
            } else if (!inside) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Це приклад(видалити цей текст) рядка";

        if (checkBrackets(input)) {
            String output = removeParenthesesContent(input);
            System.out.println("Результат: " + output);
        } else {
            System.out.println("Помилка: дужки розставлені неправильно або є вкладені дужки.");
        }
    }
}
