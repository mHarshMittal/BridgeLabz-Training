public class validateName {

    public static boolean validateName(String name) {

        if (name == null || name.isEmpty()) {
            return false;
        }

        return name.matches("[A-Za-z ]+");
    }

    public static void main(String[] args) {

        String name = "Harsh Mittal";

        if (validateName(name)) {
            System.out.println("Valid");
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }
}