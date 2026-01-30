/*
 11. Validate a credit card - Visa (starts with 4) or MasterCard (starts with 5), 16 digits.
 */
public class ValidateCreditCard {

    public static boolean isValidCreditCard(String card) {
        if (card == null) return false;
        String digitsOnly = card.replaceAll("\\D", "");
        if (digitsOnly.length() != 16) return false;
        if (digitsOnly.startsWith("4")) return true;
        if (digitsOnly.startsWith("5")) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("4123456789012345: " + (isValidCreditCard("4123456789012345") ? "Valid" : "Invalid"));
        System.out.println("5123456789012345: " + (isValidCreditCard("5123456789012345") ? "Valid" : "Invalid"));
    }
}
