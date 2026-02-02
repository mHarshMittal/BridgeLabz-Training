import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {

        String filePath = "employees.csv";
        String line;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header row
            br.readLine();

            // Count remaining rows
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }

            System.out.println("Number of records (excluding header): " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

