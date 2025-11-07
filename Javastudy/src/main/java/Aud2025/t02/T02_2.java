package Aud2025.t02;
import java.util.Scanner;

public class T02_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // число
        int k = sc.nextInt(); 

        int mask = 1 << k;
        int result = n ^ mask;
        
        System.out.println(result);
    }
}
