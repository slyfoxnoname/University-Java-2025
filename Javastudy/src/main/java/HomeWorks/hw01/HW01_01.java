package HomeWorks.hw01;

import java.util.Scanner;

public class HW01_01{
    public static void main(String[] args) {
        System.out.println("Enter ur name: ");
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        System.out.println("Hello " + name);
    }
}