import java.util.HashSet;
import java.util.Set;

public class CheckSetEquality {
    
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() != set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are sets equal? " + areSetsEqual(set1, set2));
    }
}
