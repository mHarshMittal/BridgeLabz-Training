import java.util.Scanner;

public class ReverseStringOrThrowException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            Integer.parseInt(input);

            throw new IllegalArgumentException("Invalid input");

        } catch (NumberFormatException e) {

            String reversed = "";

            for (int i = input.length() - 1; i >= 0; i--) {
                reversed += input.charAt(i);
            }

            System.out.println(reversed);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}