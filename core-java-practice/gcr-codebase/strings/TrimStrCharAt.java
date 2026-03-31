import java.util.Scanner;

public class TrimStrCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string with spaces: ");
        String text = sc.nextLine();

        int start = 0, end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;

        String trimManual = "";
        for (int i = start; i <= end; i++) {
            trimManual += text.charAt(i);
        }

        String trimmedBuiltIn = text.trim();
        boolean areEqual = trimManual.equals(trimmedBuiltIn);

        System.out.println("Manual Trim: [" + trimManual + "]");
        System.out.println("Built-in Trim: [" + trimmedBuiltIn + "]");
        System.out.println("Are both equal? " + areEqual);
        sc.close();
    }
}
