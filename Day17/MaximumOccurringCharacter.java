public class MaximumOccurringCharacter {

    public static void main(String[] args) {

        String str = "success";

        char maxChar = ' ';
        int maxCount = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
            }
        }

        System.out.println(maxChar);
    }
}