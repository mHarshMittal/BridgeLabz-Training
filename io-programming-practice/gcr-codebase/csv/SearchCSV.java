import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {

        String filePath = "employees.csv";
        String line;
        boolean found = false;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 4) {
                    continue;
                }

                String name = data[1];

                // case-insensitive search
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department : " + data[2]);
                    System.out.println("Salary     : " + data[3]);
                    found = true;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Employee not found.");
        }

        sc.close();
    }
}

