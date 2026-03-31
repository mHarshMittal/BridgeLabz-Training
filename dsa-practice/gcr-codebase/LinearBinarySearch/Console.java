import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class Console{

    public static void main(String[] args) {

        String filePath = "output.txt";

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);

            writer = new FileWriter(filePath, true); // append mode

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = reader.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(input);
                writer.write(System.lineSeparator());
            }

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing resources");
            }
        }
    }
}
