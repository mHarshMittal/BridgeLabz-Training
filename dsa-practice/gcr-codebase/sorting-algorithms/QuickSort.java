class QuickSort {

    public static void main(String[] args) {
        int[] a = { 999, 499, 1299, 299 };

        qs(a, 0, a.length - 1);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    static void qs(int[] a, int s, int e) {
        if (s < e) {
            int p = part(a, s, e);
            qs(a, s, p - 1);
            qs(a, p + 1, e);
        }
    }

    static int part(int[] a, int s, int e) {
        int p = a[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (a[j] < p) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[i + 1];
        a[i + 1] = a[e];
        a[e] = t;

        return i + 1;
    }
}
