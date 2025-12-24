import java.util.Scanner;   
public class factorCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int sum = 0;
        int product = 1;
        double sumOfSqr = 0;

        System.out.print("Factors: ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                sum += i;
                product *= i;
                sumOfSqr += Math.pow(i, 2);
            }
        }
        
        System.out.println("\nSum: " + sum);
        System.out.println("Product: " + product);
        System.out.printf("Sum of squares: %.2f%n", sumOfSqr);
        sc.close();
        
    }
}