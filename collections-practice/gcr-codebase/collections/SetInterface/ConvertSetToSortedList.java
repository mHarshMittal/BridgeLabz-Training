import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConvertSetToSortedList {
    
    public static List<Integer> convertToSortedList(Set<Integer> hashSet) {
        TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
        return new ArrayList<>(treeSet);
    }
    
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);
        
        System.out.println("Input: " + hashSet);
        List<Integer> sortedList = convertToSortedList(hashSet);
        System.out.println("Output: " + sortedList);
    }
}
