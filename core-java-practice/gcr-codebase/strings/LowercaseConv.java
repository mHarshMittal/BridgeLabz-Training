import java.util.Scanner;

public class LowercaseConv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String custLow = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                custLow += (char)(ch + 32);
            } else {
                custLow += ch;
            }
        }

        String builtInLower = text.toLowerCase();

        boolean areEqual = custLow.equals(builtInLower);

        System.out.println("Custom lowercase: " + custLow);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Are both lowercase strings equal? " + areEqual);

        sc.close();
    }
}
