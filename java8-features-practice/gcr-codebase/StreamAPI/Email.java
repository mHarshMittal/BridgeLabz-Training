import java.util.*;

public class Email {
    static void sendEmailNotification(String email) {
        System.out.println("Email sent to: " + email);
    }

    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com");

        emails.forEach(email -> sendEmailNotification(email));
    }
}
