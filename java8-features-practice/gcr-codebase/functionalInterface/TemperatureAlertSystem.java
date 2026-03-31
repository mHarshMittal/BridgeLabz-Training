import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        Predicate<Double> isOverLimit = temp -> temp > 40;

        System.out.println("35°C Alert: " + isOverLimit.test(35.0));
        System.out.println("45°C Alert: " + isOverLimit.test(45.0));
    }
}
