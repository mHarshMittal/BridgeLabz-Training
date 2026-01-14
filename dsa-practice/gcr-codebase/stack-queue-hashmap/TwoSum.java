import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}
