import org.json.JSONObject;
import org.json.XML;

public class ConvertJSONToXML {

    public static void main(String[] args) {

        String jsonString = "{ \"name\":\"Agraj\", \"age\":28, \"email\":\"agraj@example.com\" }";

        // convert JSON to JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // convert JSONObject to XML
        String xml = XML.toString(jsonObject);

        // print XML
        System.out.println(xml);
    }
}
