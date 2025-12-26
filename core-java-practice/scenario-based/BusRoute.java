import java.util.Scanner;

class BusRoute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.print("Enter distance of next stop: ");
            int d = sc.nextInt();
            total += d;

            System.out.print("Get off? (yes=1 / no=0): ");
            int ch = sc.nextInt();

            if (ch == 1)
                break;
        }

        System.out.println("Total distance travelled: " + total);
    }
}
