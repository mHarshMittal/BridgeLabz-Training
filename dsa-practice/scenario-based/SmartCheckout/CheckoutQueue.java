import java.util.LinkedList;
import java.util.Queue;

public class CheckoutQueue {
    private final Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public Customer pollCustomer() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
