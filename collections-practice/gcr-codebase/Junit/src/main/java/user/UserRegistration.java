package user;

public class UserRegistration {

    // Registers a user, validates inputs
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        // Registration logic (for this example, just assume registration is successful)
        System.out.println("User registered: " + username);
    }
}
