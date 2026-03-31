import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] array = {10, 20, 30, 40, 50};
        
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        
        try {
            try {
                int value = array[index];
                int result = value / divisor;
                System.out.println("Division result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
        
        scanner.close();
    }
}
