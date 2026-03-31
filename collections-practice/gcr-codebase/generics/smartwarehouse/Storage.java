import java.util.ArrayList;
import java.util.List;


public class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public List<T> asList() {
        return items;
    }
}

