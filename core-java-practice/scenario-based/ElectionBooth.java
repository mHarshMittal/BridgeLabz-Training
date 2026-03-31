import java.util.Scanner;

class ElectionBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter age (-1 to exit): ");
            int age = sc.nextInt();

            if (age == -1)
                break;

            if (age >= 18) {
                System.out.print("Vote (1/2/3): ");
                //int v = sc.nextInt();
                System.out.println("Vote recorded");
            } else {
                System.out.println("Not eligible");
            }
        }
        sc.close();
    }
}
