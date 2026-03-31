public class StringConcatTest {

    public static void main(String[] args) {
        int n = 1_000_000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        System.out.println("String Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        System.out.println("StringBuilder Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sf.append("a");
        }
        System.out.println("StringBuffer Time: " + (System.nanoTime() - start));
    }
}
