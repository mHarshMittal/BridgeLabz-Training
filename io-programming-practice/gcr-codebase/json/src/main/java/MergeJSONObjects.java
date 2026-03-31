import org.json.JSONObject;

public class MergeJSONObjects {

    public static void main(String[] args) {

        JSONObject json1 = new JSONObject();
        json1.put("name", "Amit");
        json1.put("email", "amit@example.com");

        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "Delhi");

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1);
    }
}
