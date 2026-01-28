import java.util.Scanner;

class FlipKey {

    public static String CleanseAndInvert(String input) {

        // null or length less than 6
        if (input == null || input.length() < 6) {
            return "";
        }

        // must contain only alphabets
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                return "";
            }
        }

        // Convert to lowercase
        input = input.toLowerCase();

        // Remove characters with even ASCII values
        String filtered = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;

            if (ascii % 2 != 0) {   // keep odd ASCII only
                filtered = filtered + ch;
            }
        }

        // Reverse the string
        String reversed = "";
        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed = reversed + filtered.charAt(i);
        }

        // Convert even index characters to uppercase
        char[] arr = reversed.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);

        if (result.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
    }
}
