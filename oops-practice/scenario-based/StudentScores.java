import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // check for invalid size 
        if (n <= 0) {
            System.out.println("Invalid number of students");
            return;
        }
        

        int[] a = new int[n];         
        int sum = 0;                  
        int max = Integer.MIN_VALUE;  
        int min = Integer.MAX_VALUE;  

        for (int i = 0; i < n; i++) {

            System.out.print("Enter score of student " + (i + 1) + ": ");

            // check non-numeric input
            if (!sc.hasNextInt()) {
                System.out.println("Non-numeric input detected");
                return;
            }

            int x = sc.nextInt();

            // negative score not allowed
            if (x < 0) {
                System.out.println("Negative score not allowed");
                return;
            }

            a[i] = x;     
            sum += x;     
            
            // update highest and lowest
            if (x > max) max = x;
            if (x < min) min = x;
        }

        // calculate average
        double avg = (double) sum / n;

        System.out.println("Average score = " + avg);
        System.out.println("Highest score = " + max);
        System.out.println("Lowest score = " + min);

        // display scores above average
        System.out.println("Scores above average:");
        for (int i = 0; i < n; i++) {
            if (a[i] > avg) {
                System.out.println(a[i]);
            }
        }

        sc.close(); 
    }
}
