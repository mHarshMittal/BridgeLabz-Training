import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {
    
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> originalMap) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();
            
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }
            
            invertedMap.get(value).add(key);
        }
        
        return invertedMap;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        
        System.out.println("Input: " + originalMap);
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);
        System.out.println("Output: " + invertedMap);
    }
}
