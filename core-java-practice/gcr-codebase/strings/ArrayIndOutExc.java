import java.util.Scanner;

public class ArrayIndOutExc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};

        System.out.print("Enter index to access name: ");
        int index = sc.nextInt();

        try {
            System.out.println("Name at index: " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        sc.close();
    }
}
