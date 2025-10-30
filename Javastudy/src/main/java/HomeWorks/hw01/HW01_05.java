package homework2025.HW01;
public class HW01_05 {
    public static void main(String[] args) {
        int N, M;

        if (args.length == 2) {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } else {
            // якщо аргументів нема — зчитуємо з консолі
            java.util.Scanner scan = new java.util.Scanner(System.in);
            System.out.print("Введите N: ");
            N = scan.nextInt();
            System.out.print("Введите M: ");
            M = scan.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int random = (int)(Math.random() * (M + 1)); // от 0 до M включно
            System.out.println(random);
        }
    }
}
