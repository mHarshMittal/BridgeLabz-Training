import java.util.ArrayList;
import java.util.List;

public class RotateList {
    
    public static void rotateList(List<Integer> list, int positions) {
        if (list.isEmpty() || positions == 0) {
            return;
        }
        
        int size = list.size();
        positions = positions % size;
        
        if (positions < 0) {
            positions = size + positions;
        }
        
        List<Integer> temp = new ArrayList<>(list.subList(0, positions));
        list.subList(0, positions).clear();
        list.addAll(temp);
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        
        System.out.println("Original List: " + numbers);
        rotateList(numbers, 2);
        System.out.println("Rotated by 2: " + numbers);
    }
}
