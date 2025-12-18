import java.util.Scanner;

public class Handshake {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStud = sc.nextInt();

        int maxHandshakes = (numberOfStud * (numberOfStud - 1)) / 2;

        System.out.println("Maximum number of handshakes: " + maxHandshakes);

        sc.close();
    }
}