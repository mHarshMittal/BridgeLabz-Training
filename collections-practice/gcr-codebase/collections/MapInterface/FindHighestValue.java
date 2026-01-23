import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindHighestValue {
    
    public static String findKeyWithHighestValue(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null;
        }
        
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        
        System.out.println("Input: " + map);
        String result = findKeyWithHighestValue(map);
        System.out.println("Key with highest value: " + result);
    }
}
