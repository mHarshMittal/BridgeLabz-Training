import java.util.Scanner;


public class AnagramOrNot {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        if (isAnagram(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
        
        sc.close();
    }
    
   
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        
        for (int i = 0; i < lowerStr1.length(); i++) {
            freq1[lowerStr1.charAt(i)]++;
            freq2[lowerStr2.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        
        return true;
    }
}

