import java.util.*;

public class SearchComparison {

    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        long start = System.nanoTime();
        linearSearch(arr, target);
        long linearTime = System.nanoTime() - start;

        Arrays.sort(arr);
        start = System.nanoTime();
        Arrays.binarySearch(arr, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Linear Search Time: " + linearTime);
        System.out.println("Binary Search Time: " + binaryTime);
    }

    static int linearSearch(int[] arr, int target) {
        for (int i : arr) {
            if (i == target) return i;
        }
        return -1;
    }
}
