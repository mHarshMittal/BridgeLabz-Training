import java.io.*;
import org.json.*;

public class JsonCsvConvert {

    static void jsonToCsv() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.json"));
        String jsonText = br.readLine();
        br.close();

        JSONArray arr = new JSONArray(jsonText);
        FileWriter fw = new FileWriter("students.csv");

        fw.write("ID,Name,Age,Marks\n");

        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            fw.write(o.getInt("id") + "," +
                     o.getString("name") + "," +
                     o.getInt("age") + "," +
                     o.getInt("marks") + "\n");
        }
        fw.close();
    }

    static void csvToJson() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        JSONArray arr = new JSONArray();
        String line;

        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            JSONObject o = new JSONObject();
            o.put("id", Integer.parseInt(d[0]));
            o.put("name", d[1]);
            o.put("age", Integer.parseInt(d[2]));
            o.put("marks", Integer.parseInt(d[3]));
            arr.put(o);
        }
        br.close();

        FileWriter fw = new FileWriter("students.json");
        fw.write(arr.toString());
        fw.close();
    }

    public static void main(String[] args) {
        try {
            jsonToCsv();
            csvToJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

