package homework2025.HW01;
import java.util.Scanner;

public class HW01_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float product = 1;  

        int[] array = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (scan.hasNextInt()) {
                array[i] = scan.nextInt();
            } else {
                System.out.println("Это не целое число!");
                return;
            }
        }

        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }

        double geometricMean = Math.sqrt(product);

        System.out.println("Произведение = " + product);
        System.out.printf("Среднее геометрическое = %.4f%n", geometricMean);
    }
}
