import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 12. Extract programming language names (Java, Python, JavaScript, Go) from text.
 */
public class ExtractProgrammingLanguages {

    public static List<String> extractProgrammingLanguages(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(extractProgrammingLanguages(text));
    }
}
