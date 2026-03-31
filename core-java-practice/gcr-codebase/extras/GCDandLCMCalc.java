import java.util.Scanner;


public class GCDandLCMCalc {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        int gcd = calcGCD(num1, num2);
        int lcm = calcLCM(num1, num2, gcd);
        
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
        
        sc.close();
    }
    
  
    public static int calcGCD(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
 
    public static int calcLCM(int a, int b, int gcd) {
        if (gcd == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd;
    }
}

