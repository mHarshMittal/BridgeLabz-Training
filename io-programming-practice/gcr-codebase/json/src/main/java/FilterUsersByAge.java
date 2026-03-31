import org.json.JSONArray;
import org.json.JSONObject;

public class FilterUsersByAge {

    public static void main(String[] args) {

        String jsonData = "["
                + "{\"name\":\"Alice\",\"age\":24},"
                + "{\"name\":\"Bob\",\"age\":30},"
                + "{\"name\":\"Charlie\",\"age\":28}"
                + "]";

        // parse JSON array
        JSONArray users = new JSONArray(jsonData);

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);

            if (user.getInt("age") > 25) {
                System.out.println(user);
            }
        }
    }
}
