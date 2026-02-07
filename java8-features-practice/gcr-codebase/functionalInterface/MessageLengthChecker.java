import java.util.function.Function;

public class MessageLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthCalculator = msg -> msg.length();

        String message = "Hello World";
        System.out.println("Length: " + lengthCalculator.apply(message));
    }
}
