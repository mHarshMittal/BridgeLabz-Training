import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {

        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            // Write header
            writer.append("ID,Name,Department,Salary\n");

            // Write employee records
            writer.append("1,Rohan,HR,45000\n");
            writer.append("2,Amit,IT,60000\n");
            writer.append("3,Rob,Finance,52000\n");
            writer.append("4,Mukul,Marketing,48000\n");
            writer.append("5,Dhruv,Sales,50000\n");

            System.out.println("CSV file created and data written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

