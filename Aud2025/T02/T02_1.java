
import java.util.Scanner;

public class T02_1{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter k: ");
        int k = scan.nextInt();
        
        System.out.println("Array size: ");
        int size = scan.nextInt();
    
        
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }


        int count = 0;
        for(int num : array){
            if(num % k == 0){
                count += 1;
            }
        }

    System.out.println(count + " nums is divided into " + k);
    }
}