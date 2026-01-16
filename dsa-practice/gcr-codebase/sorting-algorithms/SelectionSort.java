class SelectionSort {
    public static void main(String[] args) {
        int[] a = {78, 92, 65, 88};

        for (int i = 0; i < a.length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[m]) m = j;
            }
            int t = a[m];
            a[m] = a[i];
            a[i] = t;
        }

        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
