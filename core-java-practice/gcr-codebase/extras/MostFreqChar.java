// Find most frequent character in a string
import java.util.Scanner;

public class MostFreqChar {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        char mostFrequent = findMostFreqChar(input);
        
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        
        sc.close();
    }
    
    
    public static char findMostFreqChar(String str) {
        int[] freq = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }
        
        char mostFreq = str.charAt(0);
        int maxCnt = freq[mostFreq];
        
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] > maxCnt) {
                maxCnt = freq[ch];
                mostFreq = ch;
            }
        }
        
        return mostFreq;
    }
}

