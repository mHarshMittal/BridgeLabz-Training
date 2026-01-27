import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter valid numbers only");
        }
        
        scanner.close();
    }
}
