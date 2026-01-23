public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;
    
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }
    
    public void insert(int value) {
        if (count < size) {
            rear = (rear + 1) % size;
            buffer[rear] = value;
            count++;
        } else {
            front = (front + 1) % size;
            rear = (rear + 1) % size;
            buffer[rear] = value;
        }
    }
    
    public void display() {
        System.out.print("Buffer: [");
        if (count == 0) {
            System.out.println("]");
            return;
        }
        
        int current = front;
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[current]);
            if (i < count - 1) {
                System.out.print(", ");
            }
            current = (current + 1) % size;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();
        
        buffer.insert(4);
        buffer.display();
    }
}
