import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int nums = sc.nextInt();
        
        if (nums <= 1) {
            System.out.println(nums + " is not a prime number");
        } else {
            boolean isPrime = true;
            
            for (int i = 2; i < nums; i++) {
                if (nums % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                System.out.println(nums + " is a prime number");
            } else {
                System.out.println(nums + " is not a prime number");
            }
        }
        
        sc.close();
    }
}

