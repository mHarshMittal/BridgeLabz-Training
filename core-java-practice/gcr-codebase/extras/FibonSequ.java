import java.util.Scanner;


public class FibonSequ {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of terms for Fibonacci sequence: ");
        int terms = sc.nextInt();
        
        if (terms <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            geneFibon(terms);
        }
        
        sc.close();
    }
    
    
    public static void geneFibon(int n) {
        System.out.println("Fibonacci sequence up to " + n + " terms:");
        
        if (n == 1) {
            System.out.println("0");
            return;
        }
        
        if (n == 2) {
            System.out.println("0, 1");
            return;
        }
        
        int first = 0;
        int second = 1;
        
        System.out.print(first + ", " + second);
        
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        
        System.out.println();
    }
}

