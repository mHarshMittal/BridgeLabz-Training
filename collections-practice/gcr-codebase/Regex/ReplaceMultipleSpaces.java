/*
 8. Replace multiple spaces with a single space.
 */
public class ReplaceMultipleSpaces {

    public static String replaceMultipleSpaces(String text) {
        if (text == null) return "";
        return text.trim().replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String text = "This  is   an    example     with multiple    spaces.";
        System.out.println("\"" + replaceMultipleSpaces(text) + "\"");
    }
}
