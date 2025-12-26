// Prime number checker problem solution


import java.util.Scanner;


public class PrimeNum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it's prime: ");
        int num = sc.nextInt();
        
        boolean isPrime = checkPrime(num);
        
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
        
        sc.close();
    }
    
   
    public static boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        if (num % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

