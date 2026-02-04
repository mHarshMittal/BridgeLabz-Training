import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadUserJSON {

    public static void main(String[] args) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get("src/main/user.json")));

        JSONObject json = new JSONObject(content);

        String name = json.getString("name");
        String email = json.getString("email");

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
