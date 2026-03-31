import java.util.LinkedList;
import java.util.List;

public class Customer {
    private final String name;
    private final LinkedList<String> items; 

    public Customer(String name, List<String> items) {
        this.name = name;
        this.items = new LinkedList<>(items);
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getItems() {
        return items;
    }
}
