import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJSONFiles {

    public static void main(String[] args) throws Exception {

        String content1 = new String(Files.readAllBytes(Paths.get("src/main/user.json")));
        JSONObject json1 = new JSONObject(content1);

        String content2 = new String(Files.readAllBytes(Paths.get("src/main/fileToMerge.json")));
        JSONObject json2 = new JSONObject(content2);

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1);
    }
}
