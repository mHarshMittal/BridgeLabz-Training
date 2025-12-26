// Number guessing game problem solution 


import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it. Tell me if my guess is:");
        System.out.println("- 'high' if my guess is too high");
        System.out.println("- 'low' if my guess is too low");
        System.out.println("- 'correct' if I guess right\n");
        
        int minNum = 1;
        int maxNum = 100;
        int attempts = 0;
        
        while (true) {
            int guess = generateGuess(minNum, maxNum);
            attempts++;
            
            System.out.println("My guess: " + guess);
            System.out.print("Your feedback (high/low/correct): ");
            String feedback = sc.nextLine().toLowerCase();
            
            if (feedback.equals("correct")) {
                System.out.println("Great! I guessed it in " + attempts + " attempt(s).");
                break;
            } else if (feedback.equals("high")) {
                maxNum = guess - 1;
            } else if (feedback.equals("low")) {
                minNum = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
                attempts--;
                continue;
            }
            
            if (minNum > maxNum) {
                System.out.println("Something went wrong. Please restart the game.");
                break;
            }
        }
        
        sc.close();
    }
    

    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

