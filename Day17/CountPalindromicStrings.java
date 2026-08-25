import java.util.*;

public class CountPalindromicStrings {

    public static int countPalindromes(List<List<String>> list) {

        int count = 0;

        for (List<String> innerList : list) {

            for (String str : innerList) {

                String reversed = "";

                for (int i = str.length() - 1; i >= 0; i--) {
                    reversed += str.charAt(i);
                }

                if (str.equals(reversed)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        List<List<String>> list = new ArrayList<>();

        list.add(Arrays.asList("madam", "hello", "level"));
        list.add(Arrays.asList("java", "noon", "world"));

        System.out.println(countPalindromes(list));
    }
}