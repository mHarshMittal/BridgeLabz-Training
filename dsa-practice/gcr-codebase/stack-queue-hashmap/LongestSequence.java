import java.util.*;

class LongestSequence {

    public static int longestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }

        int longest = 0;

        for (int value : arr) {
            if (!set.contains(value - 1)) {
                int current = value;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSequence(arr));
    }
}
