import java.util.Scanner;

public class SubstrCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String customSubstr = "";
        for (int i = start; i < end && i < text.length(); i++) {
            customSubstr += text.charAt(i);
        }

        String builtInSubstring = text.substring(start, Math.min(end, text.length()));

        boolean areEqual = true;
        if (customSubstr.length() != builtInSubstring.length()) {
            areEqual = false;
        } else {
            for (int i = 0; i < customSubstr.length(); i++) {
                if (customSubstr.charAt(i) != builtInSubstring.charAt(i)) {
                    areEqual = false;
                    break;
                }
            }
        }

        System.out.println("Custom Substring: " + customSubstr);
        System.out.println("Built-in Substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + areEqual);
        sc.close();
    }
}
