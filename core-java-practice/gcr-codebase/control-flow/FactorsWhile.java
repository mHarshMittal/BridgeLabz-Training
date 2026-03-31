import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer");
        } else {
            System.out.println("Factors of " + number + ":");
            int counter = 1;
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }
        
        sc.close();
    }
}

