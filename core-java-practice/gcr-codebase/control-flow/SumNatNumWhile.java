import java.util.Scanner;

public class SumNatNumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            long formulaSum = (long) n * (n + 1) / 2;

            long loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }

            System.out.println("Sum using formula n*(n+1)/2: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Both computations are equal? " + (formulaSum == loopSum));
        }

        sc.close();
    }
}


