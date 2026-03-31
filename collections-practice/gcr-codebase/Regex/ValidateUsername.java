/* 
1. Validate a Username - letters, numbers, underscore; starts with letter; 5-15 chars.
 */
public class ValidateUsername {

    public static boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        System.out.println("user_123: " + (isValidUsername("user_123") ? "Valid" : "Invalid"));
        System.out.println("123user: " + (isValidUsername("123user") ? "Valid" : "Invalid"));
        System.out.println("us: " + (isValidUsername("us") ? "Valid" : "Invalid"));
    }
}
