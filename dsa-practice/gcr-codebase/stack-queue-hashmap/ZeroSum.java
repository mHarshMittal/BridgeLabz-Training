import java.util.*;

class ZeroSum {

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        // Base case: sum 0 at index -1
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumMap.get(cumulativeSum)) {
                    System.out.println("Zero sum subarray: " + (startIndex + 1) + " to " + i);
                }
            }

            sumMap.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4};
        findZeroSumSubarrays(arr);
    }
}
