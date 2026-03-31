/*
 3. Validate a Hex Color Code - # followed by 6 hex characters.
 */
public class ValidateHexColor {

    public static boolean isValidHexColor(String color) {
        if (color == null) return false;
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {
        System.out.println("#FFA500: " + (isValidHexColor("#FFA500") ? "Valid" : "Invalid"));
        System.out.println("#ff4500: " + (isValidHexColor("#ff4500") ? "Valid" : "Invalid"));
        System.out.println("#123: " + (isValidHexColor("#123") ? "Valid" : "Invalid"));
    }
}
