import java.util.LinkedList;
import java.util.ListIterator;

public class FindNthFromEnd {
    
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list.isEmpty() || n <= 0) {
            return null;
        }
        
        ListIterator<String> fastIterator = list.listIterator();
        ListIterator<String> slowIterator = list.listIterator();
        
        for (int i = 0; i < n; i++) {
            if (!fastIterator.hasNext()) {
                return null;
            }
            fastIterator.next();
        }
        
        while (fastIterator.hasNext()) {
            fastIterator.next();
            slowIterator.next();
        }
        
        return slowIterator.next();
    }
    
    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        
        System.out.println("List: " + letters);
        String result = findNthFromEnd(letters, 2);
        System.out.println("2nd element from end: " + result);
    }
}
