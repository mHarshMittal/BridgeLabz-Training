import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                System.out.println("Student ID   : " + id);
                System.out.println("Name         : " + name);
                System.out.println("Age          : " + age);
                System.out.println("Marks        : " + marks);
                System.out.println("--------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

