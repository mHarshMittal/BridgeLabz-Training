import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class User {
    int id;
    String name;
    String email;

    User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class JSONReport {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Agraj", "agraj@example.com"));
        users.add(new User(2, "Harsh", "harsh@example.com"));
        users.add(new User(3, "Mukul", "mukul@example.com"));

        // generate JSON report
        JSONArray report = new JSONArray();

        for (User user : users) {
            JSONObject json = new JSONObject();
            json.put("id", user.id);
            json.put("name", user.name);
            json.put("email", user.email);
            report.put(json);
        }

        System.out.println(report);
    }
}
