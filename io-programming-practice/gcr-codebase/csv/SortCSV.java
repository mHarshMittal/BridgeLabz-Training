import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SortCSV {
    public static void main(String[] args) {

        ArrayList<String[]> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
            String line;

            br.readLine();

            // read records
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                list.add(data);
            }

            br.close();

            // sort by salary 
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {

                    int salary1 = Integer.parseInt(list.get(i)[3]);
                    int salary2 = Integer.parseInt(list.get(j)[3]);

                    if (salary1 < salary2) {
                        String[] temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    }
                }
            }

            // print top 5 employees
            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < 5 && i < list.size(); i++) {
                System.out.println(
                        list.get(i)[1] + " - " +
                        list.get(i)[2] + " - " +
                        list.get(i)[3]
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

