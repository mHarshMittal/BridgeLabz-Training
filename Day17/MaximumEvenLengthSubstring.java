public class MaximumEvenLengthSubstring {

    public static void main(String[] args) {

        String str = "programming";

        if (str.length() % 2 == 0) {
            System.out.println(str);
        } else {
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}