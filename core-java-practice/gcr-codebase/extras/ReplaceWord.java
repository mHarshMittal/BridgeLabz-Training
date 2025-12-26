
// Replace word in a sentence
import java.util.Scanner;


public class ReplaceWord {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sente = sc.nextLine();
        
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        
        String result = replaceWord(sente, oldWord, newWord);
        
        System.out.println("Modified sentence: " + result);
        
        sc.close();
    }
    
    
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result.append(newWord);
            } else {
                result.append(words[i]);
            }
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}

