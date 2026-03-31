class HeapSort {

    public static void main(String[] args) {
        int[] a = {45000, 60000, 35000};

        heapsort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    static void heapsort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);

        for (int i = n - 1; i > 0; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            heapify(a, i, 0);
        }
    }

    static void heapify(int[] a, int n, int i) {
        int m = i, l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && a[l] > a[m]) m = l;
        if (r < n && a[r] > a[m]) m = r;

        if (m != i) {
            int t = a[i];
            a[i] = a[m];
            a[m] = t;
            heapify(a, n, m);
        }
    }
}
