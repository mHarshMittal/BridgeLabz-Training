import java.util.Scanner;

public class ArmstrongNum {
    public static boolean isArmstro(int num) {
        int temp = num, sum = 0, dig = String.valueOf(num).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, dig);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(n + (isArmstro(n) ? " is " : " is not ") + "an Armstrong number.");
        sc.close();
        }
}