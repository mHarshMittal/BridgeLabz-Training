class CountingSort {
    public static void main(String[] args) {
        int[] a = {12, 15, 11, 14, 10};
        int min = 10, max = 18;

        int[] c = new int[max - min + 1];

        for (int x : a) c[x - min]++;

        int k = 0;
        for (int i = 0; i < c.length; i++) {
            while (c[i]-- > 0) {
                a[k++] = i + min;
            }
        }

        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
