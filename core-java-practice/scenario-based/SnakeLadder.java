/*Snake & Ladder

Simulator

This problem simulates a Snake and Ladder Game. The Player
starts from 0 rolls the die to get a number between 1 to 6, finds
a safe place, ladder or a snake keeps doing till the winning spot

100 is achieved.
 */
import java.util.Random;
import java.util.Scanner;
public class SnakeLadder {
    public static void main(String[] args) {
        int playerPos = 0;
        int winningPos = 100;
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Snake and Ladder Simulator!");
        System.out.println("You need to reach position " + winningPos + " to win the game.");

        while (playerPos < winningPos) {
            System.out.print("Press Enter to roll the die...");
            sc.nextLine();

            int dieRoll = random.nextInt(6) + 1; // Roll die (1-6)
            System.out.println("You rolled a " + dieRoll);

            int option = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake

            switch (option) {
                case 0:
                    System.out.println("No Play! You stay at position " + playerPos);
                    break;
                case 1:
                    playerPos += dieRoll;
                    if (playerPos > winningPos) {
                        playerPos -= dieRoll; //
                    }
                    System.out.println("Ladder! You move up to position " + playerPos);
                    break;
                case 2:
                    playerPos -= dieRoll;
                    if (playerPos < 0) {
                        playerPos = 0; // Stay at start if below 0
                    }
                    System.out.println("Snake! You move down to position " + playerPos);
                    break;
            }
        }

        System.out.println("Congratulations! You've reached position " + winningPos + " and won the game!");
        sc.close();
    }
}













