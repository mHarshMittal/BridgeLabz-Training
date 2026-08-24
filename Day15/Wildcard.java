import java.util.*;

class NumericBox<T extends Number> {
    private T value;

    public NumericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Solution {

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;

        for (Number n : list) {
            sum += n.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println(sumOfList(intList));
        System.out.println(sumOfList(doubleList));
    }
}