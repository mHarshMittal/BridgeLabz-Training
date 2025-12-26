import java.util.Scanner;

class MetroCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bal = 200;

        while (bal > 0) {
            System.out.print("Enter distance (0 to quit): ");
            int d = sc.nextInt();

            if (d == 0)
                break;

            int fare = (d <= 5) ? 10 : (d <= 15) ? 20 : 30;

            if (bal >= fare) {
                bal -= fare;
                System.out.println("Fare: " + fare + " Balance: " + bal);
            } else {
                System.out.println("Low balance");
                break;
            }
        }
    }
}
