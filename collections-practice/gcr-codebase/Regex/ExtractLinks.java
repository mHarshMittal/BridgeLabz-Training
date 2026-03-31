import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 7. Extract links (http/https URLs) from text.
 */
public class ExtractLinks {

    public static List<String> extractLinks(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("https?://[^\\s]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String link = matcher.group();
            if (link.endsWith(".") || link.endsWith(",")) {
                link = link.substring(0, link.length() - 1);
            }
            result.add(link);
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println(extractLinks(text));
    }
}
