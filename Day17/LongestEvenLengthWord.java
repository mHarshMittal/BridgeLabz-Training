public class LongestEvenLengthWord {

    public static void main(String[] args) {

        String sentence = "Java programming is very interesting and useful";

        String[] words = sentence.split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() % 2 == 0 && word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println(longest);
    }
}