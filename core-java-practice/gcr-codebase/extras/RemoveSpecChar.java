// Remove specific character from String

import java.util.Scanner;


public class RemoveSpecChar {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        System.out.print("Enter character to remove: ");
        char charToRem = sc.nextLine().charAt(0);
        
        String result = removeChar(input, charToRem);
        
        System.out.println("Modified String: " + result);
        
        sc.close();
    }
    
  
    public static String removeChar(String str, char ch) {
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                res.append(str.charAt(i));
            }
        }
        
        return res.toString();
    }
}

