package homework2025.HW01;
import java.util.Scanner;

public class HW01_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long product = 1;  // используем long, чтобы влезли большие числа

        System.out.print("Array size: ");
        int size = scan.nextInt();
        int[] array = new int[size];

        // Заполняем массив
        for (int i = 0; i < array.length; i++) {
            if (scan.hasNextInt()) {
                array[i] = scan.nextInt();
            } else {
                System.out.println("Это не целое число!");
                return;
            }
        }

        // Считаем произведение всех элементов
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }

        System.out.println(product);
    }
}
