import java.util.*;

public class EvenWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+");

        String answer = "";

        for (String word : words) {
            if (word.length() % 2 == 0) {
                if (word.length() > answer.length()) {
                    answer = word;
                }
            }
        }

        System.out.println(answer);

        sc.close();
    }
}