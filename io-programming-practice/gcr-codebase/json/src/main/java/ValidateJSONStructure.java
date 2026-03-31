import org.json.JSONObject;

public class ValidateJSONStructure {

    public static void main(String[] args) {

        String json = "{ \"name\": \"Alice\", \"age\": 25 }";

        try {
            new JSONObject(json);
            System.out.println("Valid JSON");
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}
