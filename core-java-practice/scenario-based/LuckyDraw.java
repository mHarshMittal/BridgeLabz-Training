import java.util.Scanner;

class LuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter number (-1 to stop): ");
            int n = sc.nextInt();

            if (n == -1)
                break;

            if (n <= 0)
                continue;

            if (n % 3 == 0 && n % 5 == 0)
                System.out.println("Gift Won!");
            else
                System.out.println("No Gift");
        }
    }
}
