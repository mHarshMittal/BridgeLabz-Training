import java.util.Scanner;

public class MaxOfThree {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num1 = takeInp("Enter first number: ");
        int num2 = takeInp("Enter second number: ");
        int num3 = takeInp("Enter third number: ");

        int max = findMax(num1, num2, num3);

        System.out.println("The maximum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + max);

        sc.close();
    }

    public static int takeInp(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }
}
