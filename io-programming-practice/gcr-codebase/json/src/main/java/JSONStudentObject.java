import org.json.JSONArray;
import org.json.JSONObject;

public class JSONStudentObject {

    public static void main(String[] args) {

        JSONArray arr = new JSONArray();
        arr.put("Python");
        arr.put("Math");

        JSONObject obj = new JSONObject();
        obj.put("name", "Rohan");
        obj.put("age", 22);
        obj.put("subjects", arr);

        System.out.println(obj.toString());

    }

}