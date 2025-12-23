import java.util.Scanner;

public class UppercaseComparision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customUpp = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                customUpp += (char)(ch - 32);
            } else {
                customUpp += ch;
            }
        }

        String builtInUpp = text.toUpperCase();

        boolean areEqual = customUpp.equals(builtInUpp);

        System.out.println("Custom uppercase: " + customUpp);
        System.out.println("Built-in uppercase: " + builtInUpp);
        System.out.println("Are both uppercase strings equal? " + areEqual);

        sc.close();
    }
}
