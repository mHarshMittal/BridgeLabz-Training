import java.util.HashMap;
import java.util.Map;

public class ItemCatalog {
    private final Map<String, Integer> priceMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();

    public void upsertItem(String id, int price, int stock) {
        priceMap.put(id, price);
        stockMap.put(id, stock);
    }

    public Integer getPrice(String id) {
        return priceMap.get(id);
    }

    public int getStock(String id) {
        return stockMap.getOrDefault(id, 0);
    }

    public boolean purchase(String id, int quantity) {
        int current = stockMap.getOrDefault(id, 0);
        if (current < quantity) {
            return false;
        }
        stockMap.put(id, current - quantity);
        return true;
    }
}
