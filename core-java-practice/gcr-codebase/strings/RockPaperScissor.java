import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] opt = { "rock", "paper", "scissors" };
        int userWins = 0, compWin = 0;

        System.out.print("Enter number of games: ");
        int game = sc.nextInt();

        for (int i = 0; i < game; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = opt[(int) (Math.random() * 3)];

            System.out.println("Computer chose: " + comp);

            if (user.equals(comp)) {
                System.out.println("Draw");
            } else if ((user.equals("rock") && comp.equals("scissors")) ||
                    (user.equals("paper") && comp.equals("rock")) ||
                    (user.equals("scissors") && comp.equals("paper"))) {
                userWins++;
                System.out.println("You win!");
            } else {
                compWin++;
                System.out.println("Computer wins!");
            }
        }

        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWin);
        System.out.printf("User Win %%: %.2f%%\n", (userWins * 100.0 / game));
        System.out.printf("Computer Win %%: %.2f%%\n", (compWin * 100.0 / game));

        sc.close();
    }
}
