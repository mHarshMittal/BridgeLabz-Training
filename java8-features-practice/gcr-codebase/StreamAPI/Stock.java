import java.util.*;

public class Stock {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(120.5, 121.8, 119.0);

        prices.forEach(p -> System.out.println("Stock Price: " + p));
    }
}
