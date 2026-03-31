/*. Scenario: You are tasked with creating a utility class for mathematical operations.
Implement the following functionalities using separate methods:
● A method to calculate the factorial of a number.
● A method to check if a number is prime.
● A method to find the greatest common divisor (GCD) of two numbers.
● A method to find the nth Fibonacci number.
● Test your methods with various inputs, including edge cases like zero, one, and
negative numbers. */


class MathUtility {

    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // factorial not defined for negative numbers
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0, 1 and negatives are not prime
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find GCD
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to find nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1; // invalid input
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Main method to test all cases
    public static void main(String[] args) {

        // Factorial tests
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of -3: " + factorial(-3));

        // Prime tests
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 1 prime? " + isPrime(1));
        System.out.println("Is -5 prime? " + isPrime(-5));

        // GCD tests
        System.out.println("GCD of 24 and 36: " + gcd(24, 36));
        System.out.println("GCD of -10 and 5: " + gcd(-10, 5));

        // Fibonacci tests
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("Fibonacci of 0: " + fibonacci(0));
        System.out.println("Fibonacci of -4: " + fibonacci(-4));
    }
}
