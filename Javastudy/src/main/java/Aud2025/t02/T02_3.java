package Aud2025.t02;
import java.util.Scanner;

public class T02_3 {
    public static int fibRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibIterative(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введiть n: ");
        int n = scan.nextInt();

        
        int rec = fibRecursive(n);
        System.out.println("Рекурсивно: " + rec);

        
        int iter = fibIterative(n);
        System.out.println("Iтеративно: " + iter);


        if (rec == iter) {
            System.out.println("Результати збiгаються");
        } else {
            System.out.println("Результати рiзнi");
        }
    }
}
