import org.json.JSONArray;
import org.json.JSONObject;

public class FilterJSONByAge {

    public static void main(String[] args) {

        String jsonData = "["
                + "{\"name\":\"Amit\",\"age\":24},"
                + "{\"name\":\"Rohan\",\"age\":30},"
                + "{\"name\":\"Rohit\",\"age\":28}"
                + "]";

        // Parse json array
        JSONArray array = new JSONArray(jsonData);

        // Filter records where age > 25
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            if (obj.getInt("age") > 25) {
                System.out.println(obj);
            }
        }
    }
}
