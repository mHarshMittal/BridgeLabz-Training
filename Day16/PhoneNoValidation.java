public class PhoneValidation {

    public static boolean isValidPhone(String phone) {
        return phone.matches(
            "^(\\+\\d{1,3}[-.]?)?\\(?\\d{3}\\)?[- .]?\\d{3}[- .]?\\d{4}$"
        );
    }

    public static void main(String[] args) {

        String[] phoneNumbers = {
            "5551234567",
            "555-123-4567",
            "+1 555-123-4567",
            "555123",
            "555-ABC-4567"
        };

        for (String phone : phoneNumbers) {
            System.out.println(phone + " : " + isValidPhone(phone));
        }
    }
}