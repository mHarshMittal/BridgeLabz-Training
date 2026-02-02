import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        try {
            BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
            BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
            FileWriter fw = new FileWriter("students_merged.csv");

            String line;

            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] d = line.split(",");
                map.put(d[0], d[1] + "," + d[2]);
            }

            fw.write("ID,Name,Age,Marks,Grade\n");
            br2.readLine();

            while ((line = br2.readLine()) != null) {
                String[] d = line.split(",");
                fw.write(d[0] + "," + map.get(d[0]) + "," + d[1] + "," + d[2] + "\n");
            }

            br1.close();
            br2.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

