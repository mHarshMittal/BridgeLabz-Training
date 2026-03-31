import java.util.*;

public class DataStructureSearch {

    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start = System.nanoTime();
        for (int i : array) {
            if (i == target) break;
        }
        System.out.println("Array Search Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.nanoTime() - start));

        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.nanoTime() - start));
    }
}
