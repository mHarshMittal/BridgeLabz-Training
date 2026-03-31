// Longest word in String
import java.util.Scanner;

public class LongestWord {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        String longestWord = findLongestWord(sentence);
        
        System.out.println("Longest word: " + longestWord);
        
        sc.close();
    }
    

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longestWord = "";
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }
}

