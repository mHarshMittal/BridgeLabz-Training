

// Problem 1: Count Vowels and Consonants
import java.util.Scanner;
 
public class VowelConsCount {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        int[] counts = CountVowelCons(input);
        
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
        
        sc.close();
    }
    
    
    public static int[] CountVowelCons(String str) {
        int vowelCnt = 0;
        int consoCnt = 0;
        
        String lowerStr = str.toLowerCase();
        
        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCnt++;
                } else {
                    consoCnt++;
                }
            }
        }
        
        return new int[]{vowelCnt, consoCnt};
    }
}

