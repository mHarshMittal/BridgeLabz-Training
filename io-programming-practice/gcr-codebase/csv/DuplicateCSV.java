import java.io.*;
import java.util.*;

public class DuplicateCSV {
    public static void main(String[] args) {

        Set<String> ids = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                if (!ids.add(d[0])) {
                    System.out.println("Duplicate: " + line);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

