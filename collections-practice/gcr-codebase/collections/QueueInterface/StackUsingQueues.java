import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public StackUsingQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    
    public void push(int value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.remove();
    }
    
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element after pop: " + stack.top());
    }
}
