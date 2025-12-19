import java.util.Scanner;

public class RocketCountFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting countdown value: ");
        int start = sc.nextInt();

        for (int count = start; count >= 1; count--) {
            System.out.println(count);
        }

        System.out.println("Launch!");

        sc.close();
    }
}


