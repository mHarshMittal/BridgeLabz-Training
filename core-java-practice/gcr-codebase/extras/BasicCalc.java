import java.util.Scanner;

public class BasicCalc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Basic Calculator");
        System.out.println("Operations available:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Choose an operation (1-4): ");

        int ch = sc.nextInt();

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        double res = 0;
        boolean validOperation = true;

        switch (ch) {
            case 1:
                res = add(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + res);
                break;
            case 2:
                res = subtract(num1, num2);
                System.out.println(num1 + " - " + num2 + " = " + res);
                break;
            case 3:
                res = multiply(num1, num2);
                System.out.println(num1 + " * " + num2 + " = " + res);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                } else {
                    res = divide(num1, num2);
                    System.out.println(num1 + " / " + num2 + " = " + res);
                }
                break;
            default:
                System.out.println("Invalid operation choice.");
                validOperation = false;
        }

        sc.close();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}
