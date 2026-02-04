import org.json.JSONArray;
import org.json.CDL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertCSVToJSON {

    public static void main(String[] args) throws Exception {

        // Read CSV file
        String csvData = new String(Files.readAllBytes(Paths.get("src/main/data.csv")));

        // Convert CSV to JSON array
        JSONArray jsonArray = CDL.toJSONArray(csvData);

        // Print JSON
        System.out.println(jsonArray);
    }
}
