import java.util.ArrayList;
import java.util.Arrays;

public class CommonCharacter {

    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>(
                Arrays.asList("ae", "bc", "zx")
        );

        ArrayList<String> B = new ArrayList<>(
                Arrays.asList("ab", "vb", "op")
        );

        for (int i = 0; i < A.size(); i++) {

            boolean found = false;

            for (char ch : A.get(i).toCharArray()) {

                if (B.get(i).indexOf(ch) != -1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}