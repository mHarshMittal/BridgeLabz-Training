import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter {
    private final Comparator<Student> comparator;

    public MergeSorter(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public List<Student> mergeSort(List<Student> input) {
        if (input.size() <= 1) {
            return new ArrayList<>(input);
        }
        int mid = input.size() / 2;
        List<Student> left = mergeSort(input.subList(0, mid));
        List<Student> right = mergeSort(input.subList(mid, input.size()));
        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>(left.size() + right.size());
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            Student l = left.get(i);
            Student r = right.get(j);
            int cmp = comparator.compare(l, r);
            if (cmp <= 0) {
                merged.add(l); 
                i++;
            } else {
                merged.add(r);
                j++;
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }
        return merged;
    }
}
