import java.io.BufferedReader;
import java.io.FileReader;

public class ValidateCSV {
    public static void main(String[] args) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "\\d{10}";

        try {
            BufferedReader br = new BufferedReader(new FileReader("users.csv"));
            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean emailValid = email.matches(emailRegex);
                boolean phoneValid = phone.matches(phoneRegex);

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid row: " + line);

                    if (!emailValid) {
                        System.out.println("Reason: Invalid email format");
                    }

                    if (!phoneValid) {
                        System.out.println("Reason: Phone number must contain exactly 10 digits");
                    }

                    System.out.println();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
