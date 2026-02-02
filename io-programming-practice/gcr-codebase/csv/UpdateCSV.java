import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
            FileWriter fw = new FileWriter("employees_updated.csv");

            String line;

            // write header
            fw.write(br.readLine() + "\n");

            // read remaining lines
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String dept = data[2];
                int salary = Integer.parseInt(data[3]);

                // increase salary for IT department
                if (dept.equals("IT")) {
                    salary = salary + (salary * 10 / 100);
                }

                // write updated record
                fw.write(data[0] + "," + data[1] + "," + data[2] + "," + salary + "\n");
            }

            br.close();
            fw.close();

            System.out.println("Updated CSV file created.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

