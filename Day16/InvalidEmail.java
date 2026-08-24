public class Solution {

    public static boolean isValidEmail(String email) {
        return email.matches(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }

    public static void main(String[] args) {

        String[] emails = {
            // Valid emails
            "user@example.com",
            "john.doe@gmail.com",
            "test123@yahoo.in",
            "user_name@company.org",
            "abc+test@domain.co.in",

            // Invalid emails
            "userexample.com",      // Missing @
            "user@domain",          // Missing 
            "user..name@email.com", // Consecutive dots
            "@example.com",         // Missing username
            "user@.com"             // Invalid domain
        };

        for (String email : emails) {
            System.out.println(email + " : " + isValidEmail(email));
        }
    }
}