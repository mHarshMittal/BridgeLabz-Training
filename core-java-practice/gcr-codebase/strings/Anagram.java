import java.util.*;

class Anagram {
    static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] f = new int[256];
        for (int i = 0; i < a.length(); i++) {
            f[a.charAt(i)]++;
            f[b.charAt(i)]--;
        }
        for (int x : f) if (x != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(check(sc.nextLine(), sc.nextLine()));
        sc.close();
    }

}
