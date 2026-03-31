import java.util.*;

// Ticket price optimizer using quick sort to surface cheapest tickets.
public class EventManager {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>(List.of(1200, 450, 2300, 800, 1500, 500));
        quickSort(prices, 0, prices.size() - 1);
        System.out.println("Sorted prices: " + prices);
        System.out.println("Top 3 cheapest: " + prices.subList(0, Math.min(3, prices.size())));
    }

    static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

