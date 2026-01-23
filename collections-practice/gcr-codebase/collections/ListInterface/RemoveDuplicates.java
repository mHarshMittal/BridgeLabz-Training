import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (Integer element : list) {
            seen.add(element);
        }
        return new ArrayList<>(seen);
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        
        System.out.println("Input: " + numbers);
        List<Integer> result = removeDuplicates(numbers);
        System.out.println("Output: " + result);
    }
}
