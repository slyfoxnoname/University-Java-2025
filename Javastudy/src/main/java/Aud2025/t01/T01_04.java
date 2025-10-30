import java.util.Arrays;
import java.util.Scanner;

public class T01_04{
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            double d = in.nextDouble();
            System.out.println(Arrays.toString(args));
        }
    }

}