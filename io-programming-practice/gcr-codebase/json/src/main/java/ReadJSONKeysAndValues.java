import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONKeysAndValues {

    public static void main(String[] args) throws Exception {

        // read json file
        String content = new String(Files.readAllBytes(Paths.get("data.json")));

        // parse json
        JSONObject json = new JSONObject(content);

        // print all keys and values
        for (String key : json.keySet()) {
            System.out.println(key + " : " + json.get(key));
        }
    }
}
