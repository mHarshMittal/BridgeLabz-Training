// check pallindrome problem solution 
import java.util.Scanner;


public class Palindrome {
    
    public static void main(String[] args) {
        String inp = takeInput();
        boolean isPallim = checkPali(inp);
        displayRes(inp, isPallim);
    }
    

    public static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = sc.nextLine();
        sc.close();
        return input;
    }
    

    public static boolean checkPali(String str) {
        String lowerStr = str.toLowerCase().replaceAll("\\s+", "");
        int left = 0;
        int right = lowerStr.length() - 1;
        
        while (left < right) {
            if (lowerStr.charAt(left) != lowerStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    
    public static void displayRes(String str, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
}




