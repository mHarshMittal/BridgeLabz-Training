/**
 * 15. Validate a Social Security Number - format 123-45-6789 (3-2-4 digits).
 */
public class ValidateSsn {

    public static boolean isValidSsn(String ssn) {
        if (ssn == null) return false;
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println("123-45-6789: " + (isValidSsn("123-45-6789") ? "Valid" : "Invalid"));
        System.out.println("123456789: " + (isValidSsn("123456789") ? "Valid" : "Invalid"));
    }
}
