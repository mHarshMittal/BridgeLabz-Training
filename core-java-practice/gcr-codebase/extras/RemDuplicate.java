// Remove Duplicate from String
import java.util.Scanner;

public class RemDuplicate {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String result = removeDupli(input);
        
        System.out.println("String after removing duplicates: " + result);
        
        sc.close();
    }
    
    
    public static String removeDupli(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                result.append(ch);
                seen[ch] = true;
            }
        }
        
        return result.toString();
    }
}

