import java.util.Scanner;
import java.util.Arrays;

public class WordSplitcomp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] builtinWord = text.split(" ");
        String[] manualWord = new String[builtinWord.length];
        String word = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.isEmpty()) {
                manualWord[index++] = word;
                word = "";
            }
        }
        if (!word.isEmpty()) {
            manualWord[index++] = word;
        }

        boolean areEqual = Arrays.equals(builtinWord, manualWord);

        System.out.println("Manual Split: " + Arrays.toString(manualWord));
        System.out.println("Built-in Split: " + Arrays.toString(builtinWord));
        System.out.println("Are both equal? " + areEqual);
        sc.close();
    }
}
