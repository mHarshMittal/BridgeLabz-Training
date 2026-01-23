import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
    private HashMap<String, Double> priceMap;
    private LinkedHashMap<String, Product> orderMap;
    
    public ShoppingCart() {
        this.priceMap = new HashMap<>();
        this.orderMap = new LinkedHashMap<>();
    }
    
    public void addProduct(Product product) {
        priceMap.put(product.getName(), product.getPrice());
        orderMap.put(product.getName(), product);
    }
    
    public Map<String, Double> getPrices() {
        return new HashMap<>(priceMap);
    }
    
    public LinkedHashMap<String, Product> getItemsByOrder() {
        return new LinkedHashMap<>(orderMap);
    }
    
    public TreeMap<Double, String> getItemsSortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }
        return sortedByPrice;
    }
}
