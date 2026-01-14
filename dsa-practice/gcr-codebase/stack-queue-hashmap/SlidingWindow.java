import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    public static void maxInWindows(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements outside window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Print max once window is formed
            if (i >= k - 1) {
                System.out.print(arr[deque.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        maxInWindows(arr, k);
    }
}
