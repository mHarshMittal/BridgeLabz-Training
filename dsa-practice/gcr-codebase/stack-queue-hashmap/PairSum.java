import java.util.*;

class PairSum {

    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> visited = new HashSet<>();

        for (int value : arr) {
            int required = target - value;

            if (visited.contains(required)) {
                System.out.println("Pair found: " + value + ", " + required);
                return true;
            }
            visited.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        System.out.println(hasPair(arr, target));
    }
}
