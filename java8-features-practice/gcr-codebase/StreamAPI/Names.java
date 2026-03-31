import java.util.*;

public class Names {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("john", "alex", "maria");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}
