
//Problem 2: Reverse a String
import java.util.Scanner; 
public class ReverseStr {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String reverse = reverseStr(input);
        
        System.out.println("Reversed string: " + reverse);
        
        sc.close();
    }
    
    
    public static String reverseStr(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}

