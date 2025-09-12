
public class T01_01 {
    public static void main(String[] args) {
        double s = 0;
        for (String arg : args) {
            try {
                s += Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                System.out.println("Невозможно преобразовать в число: " + arg);
            }
        }
        System.out.println("Сумма: " + s);
    }
}
