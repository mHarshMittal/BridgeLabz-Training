import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();

        BigDecimal x = BigDecimal.valueOf(a);
        BigDecimal y = BigDecimal.valueOf(b);

        BigDecimal result = x.add(y)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println(result);

        sc.close();
    }
}