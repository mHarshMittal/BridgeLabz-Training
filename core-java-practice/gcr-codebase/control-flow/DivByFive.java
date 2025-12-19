import java.util.Scanner;

public class DivByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        // check if no is div or not 
        boolean isDivisible = (number % 5 == 0);
        // give true or false
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);

        sc.close();
    }
}
