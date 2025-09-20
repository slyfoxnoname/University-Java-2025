
import java.util.Scanner;

public class HW01_02{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size: "); int size = scan.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            
            array[i] = scan.nextInt();
        }
        System.out.println("Mirror array: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
        
        
    }
}   