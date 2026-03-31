import java.util.Arrays;

public class Challenge {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }
    
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        
        System.out.println("=== Challenge Problem ===");
        System.out.println("Array: [3, 4, -1, 1]");
        
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive: " + missing);
        
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        int target = 3;
        int index = binarySearch(arr, target);
        System.out.println("Binary search for " + target + ": index " + index);
        System.out.println();
        
        int[] arr2 = {1, 2, 0};
        System.out.println("Array: [1, 2, 0]");
        int missing2 = findFirstMissingPositive(arr2);
        System.out.println("First missing positive: " + missing2);
        
        Arrays.sort(arr2);
        int target2 = 2;
        int index2 = binarySearch(arr2, target2);
        System.out.println("Binary search for " + target2 + ": index " + index2);
    }
}
