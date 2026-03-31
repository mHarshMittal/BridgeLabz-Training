interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }
}

public class PasswordStrengthValidatorApp {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("pass123"));
        System.out.println(SecurityUtils.isStrongPassword("StrongPass123"));
    }
}
