import java.util.*;

public class Sensor {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(20, 45, 30, 60);
        int threshold = 40;

        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("High Reading: " + r));
    }
}
