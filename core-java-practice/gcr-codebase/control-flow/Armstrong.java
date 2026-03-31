import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int sum = 0;
        int originalNumber = num;
        
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            int cube = digit * digit * digit;
            sum = sum + cube;
            originalNumber = originalNumber / 10;
        }
        
        if (num == sum) {
            System.out.println(num + " is an Armstrong number");
        } else {
            System.out.println(num + " is not an Armstrong number");
        }
        
        sc.close();
    }
}

