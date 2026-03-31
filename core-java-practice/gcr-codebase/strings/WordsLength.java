import java.util.Scanner;

public class WordsLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine() + " ";

        String word = "";
        System.out.println("Word\tLength");
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.isEmpty()) {
                System.out.println(word + "\t" + word.length());
                word = "";
            }
        }
        sc.close();
    }
}
