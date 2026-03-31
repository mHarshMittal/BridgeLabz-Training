import java.util.Scanner;

public class StrIndOutExce{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        try {
            char ch = text.charAt(text.length() + 1);
            System.out.println("Character at index out of bounds: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }

        sc.close();
    }
}
