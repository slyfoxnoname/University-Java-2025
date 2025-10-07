package homework2025.HW02;
import java.util.Scanner;

public class HW02_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size of arrays (n): ");
        int n = scan.nextInt();

        int[] array_1 = new int[n];
        int[] array_2 = new int[n]; 
        int scalar = 0; 

        // Ввід елементів першого масиву
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++) {
            array_1[i] = scan.nextInt();
        }

        // Ввід елементів другого масиву
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n; i++) {
            array_2[i] = scan.nextInt();
        }

        // Скалярний добуток
        for (int i = 0; i < n; i++) {
            scalar += array_1[i] * array_2[i];
        }

        System.out.println("Scalar product = " + scalar);
    }
}
