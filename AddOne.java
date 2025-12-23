import java.util.Arrays;

public class AddOne {

    public static void main(String[] args) {

        int[] a = {3, 5, 9};

        int n = a.length;

        if (a[n - 1] != 9) {
            a[n - 1]++;
            System.out.println(Arrays.toString(a));
            return;
        }

        int[] b = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }

        b[n - 1] = 1;
        b[n] = 0;

        for (int i = 0; i < b.length; i++) {
            b[i]++;
        }

        System.out.println(Arrays.toString(b));
    }
}
