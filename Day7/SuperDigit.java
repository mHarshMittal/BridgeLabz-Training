import java.util.*;

public class SuperDigit {

    public static int superDigit(String n, int k) {

        long sum = 0;

        // Find sum of digits of n
        for (char c : n.toCharArray()) {
            sum += c - '0';
        }

        // Because n is repeated k times
        sum = sum * k;

        // Keep adding digits until one digit remains
        while (sum >= 10) {
            long temp = 0;

            while (sum > 0) {
                temp += sum % 10;
                sum = sum / 10;
            }

            sum = temp;
        }

        return (int) sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String n = scanner.next();
        int k = scanner.nextInt();

        System.out.println(superDigit(n, k));

        scanner.close();
    }
}