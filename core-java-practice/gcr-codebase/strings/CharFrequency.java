import java.util.*;

class CharFrequency {
    static String[][] freq(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        String[][] r = new String[s.length()][2];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (f[c] > 0) {
                r[k][0] = "" + c;
                r[k][1] = "" + f[c];
                f[c] = 0;
                k++;
            }
        }
        return Arrays.copyOf(r, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] a = freq(sc.nextLine());
        for (String[] x : a) System.out.println(x[0] + " " + x[1]);
    }
}
