import java.util.*;

public class MaxValue {

    public static int[] maxValues(int n, int[] pos) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int p : pos) {
            min = Math.min(min, p);
            max = Math.max(max, p);
        }

        int[] result = new int[n];

        for (int j = 0; j < n; j++) {
            result[j] = Math.max(
                Math.abs(j - min),
                Math.abs(j - max)
            );
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] pos = new int[m];

        for (int i = 0; i < m; i++) {
            pos[i] = sc.nextInt();
        }

        int[] result = maxValues(n, pos);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}