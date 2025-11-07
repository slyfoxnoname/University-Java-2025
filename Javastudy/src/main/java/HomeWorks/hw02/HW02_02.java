package HomeWorks.hw02;
import java.util.Scanner;

public class HW02_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number (0..65535): ");
        int num = scan.nextInt();   // 2-байтовое число (0..65535)

        int count = 0;
        for (int i = 0; i < 16; i++) {
            if ((num & 1) == 0) { // проверяем младший бит
                count++;
            }
            num >>= 1; // сдвигаем вправо
        }

        System.out.println("Quantity 0 bite: " + count);
    }
}
