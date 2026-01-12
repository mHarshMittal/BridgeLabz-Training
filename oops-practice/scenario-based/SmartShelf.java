import java.util.*;

// Real-time book arrangement using insertion sort.
public class SmartShelf {
    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();
        shelf.addBook("Zebra Tales");
        shelf.addBook("Alpha Beta");
        shelf.addBook("Delta Science");
        shelf.addBook("Beta World");
        System.out.println(shelf.getSortedBooks());
    }

    private final List<String> titles = new ArrayList<>();

    void addBook(String title) {
        titles.add(title);
        insertionSort(titles);
    }

    List<String> getSortedBooks() {
        return Collections.unmodifiableList(titles);
    }

    private void insertionSort(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareToIgnoreCase(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}

