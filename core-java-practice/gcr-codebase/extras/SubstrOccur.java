// find  substring occurrences in a string
import java.util.Scanner;


public class SubstrOccur {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the main string: ");
        String mainStr = sc.nextLine();
        
        System.out.print("Enter the substring to find: ");
        String substr = sc.nextLine();
        
        int count = countSubstrOccur(mainStr, substr);
        
        System.out.println("The substring appears " + count + " time(s).");
        
        sc.close();
    }
    
    
    public static int countSubstrOccur(String mainString, String substring) {
        if (substring.length() == 0) {
            return 0;
        }
        
        int cnt = 0;
        int idx = 0;
        
        while ((idx = mainString.indexOf(substring, idx)) != -1) {
            cnt++;
            idx += substring.length();
        }
        
        return cnt;
    }
}

