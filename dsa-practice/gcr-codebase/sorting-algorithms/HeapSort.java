class HeapSort {

    public static void main(String[] args) {
        int[] a = {45000, 60000, 35000};

        hs(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    static void hs(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) hf(a, n, i);

        for (int i = n - 1; i > 0; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            hf(a, i, 0);
        }
    }

    static void hf(int[] a, int n, int i) {
        int m = i, l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && a[l] > a[m]) m = l;
        if (r < n && a[r] > a[m]) m = r;

        if (m != i) {
            int t = a[i];
            a[i] = a[m];
            a[m] = t;
            hf(a, n, m);
        }
    }
}
