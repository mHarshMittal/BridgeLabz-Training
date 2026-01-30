import java.util.regex.Pattern;

/*
 9. Censor bad words in a sentence - replace with ****.
 */
public class CensorBadWords {

    public static String censorBadWords(String text, String[] badWords) {
        if (text == null) return "";
        String result = text;
        for (String word : badWords) {
            result = result.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        System.out.println(censorBadWords(text, new String[]{"damn", "stupid"}));
    }
}
