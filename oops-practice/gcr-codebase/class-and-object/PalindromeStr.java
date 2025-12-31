public class PalindromeStr {
    String text;

    // Constructor 
    public PalindromeStr(String text) {
        this.text = text;
    }

    // Method for pallindrome check
    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\s+", "").toLowerCase(); // remove spaces and convert to lowercase
        String reversed = new StringBuilder(cleaned).reverse().toString(); // reverse the string
        return cleaned.equals(reversed); 
    }

    // Method to display result
    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome: " + isPalindrome());
    }

    // Main method 
    public static void main(String[] args) {
        PalindromeStr checker = new PalindromeStr("madam");
        checker.displayResult();
    }
}