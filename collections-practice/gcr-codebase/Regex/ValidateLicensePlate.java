/*
 2. Validate a License Plate - two uppercase letters followed by four digits.
 */
public class ValidateLicensePlate {

    public static boolean isValidLicensePlate(String plate) {
        if (plate == null) return false;
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        System.out.println("AB1234: " + (isValidLicensePlate("AB1234") ? "Valid" : "Invalid"));
        System.out.println("A12345: " + (isValidLicensePlate("A12345") ? "Valid" : "Invalid"));
    }
}
