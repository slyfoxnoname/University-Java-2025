package HomeWorks.hm05;

public class B05_02 {
    public static boolean conditionA(String str) {
        if (str.length() < 2) return false;

        char first = str.charAt(0);
        if (!Character.isDigit(first) || first == '0') return false;

        int number = Character.getNumericValue(first);
        String letters = str.substring(1);

        // перевіряємо, що далі лише літери, і їх кількість = цифрі
        return letters.matches("[a-zA-Z]+") && letters.length() == number;
    }

    public static boolean conditionB(String str) {
        int digitCount = 0;
        int digitValue = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                digitValue = Character.getNumericValue(c);
            }
        }
        return digitCount == 1 && digitValue == str.length();
    }

    public static boolean conditionC(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum == str.length();
    }

    public static void main(String[] args) {
        String input = "1a 2qe 3ee 43";

        System.out.println("String: " + input);
        System.out.println("a) " + (conditionA(input) ? "YES" : "NO"));
        System.out.println("b) " + (conditionB(input) ? "YES" : "NO"));
        System.out.println("c) " + (conditionC(input) ? "YES" : "NO"));
    }
}
