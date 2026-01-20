import java.util.*;

public class SortingComparison {

    public static void main(String[] args) {
        int size = 10000;
        int[] arr1 = generate(size);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        long start = System.nanoTime();
        bubbleSort(arr1);
        System.out.println("Bubble Sort Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("Merge Sort Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        Arrays.sort(arr3);
        System.out.println("Quick Sort Time: " + (System.nanoTime() - start));
    }

    static int[] generate(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(n);
        return arr;
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, l, temp.length);
    }
}
