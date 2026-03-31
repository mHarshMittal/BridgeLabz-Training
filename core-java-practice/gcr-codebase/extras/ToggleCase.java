// toggle case of each character in a string

import java.util.Scanner;


public class ToggleCase {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String toggled = toggleCase(input);
        
        System.out.println("Toggled case string: " + toggled);
        
        sc.close();
    }
    
   
    public static String toggleCase(String str) {
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                res.append((char)(ch + 32));
            } else if (ch >= 'a' && ch <= 'z') {
                res.append((char)(ch - 32));
            } else {
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}

