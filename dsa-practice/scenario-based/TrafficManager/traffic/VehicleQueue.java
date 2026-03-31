package traffic;

class VehicleQueue {
    private String[] q;
    private int f = 0, r = 0, size = 0;

    VehicleQueue(int cap) {
        q = new String[cap];
    }

    void enqueue(String id) {
        if (size == q.length) {
            System.out.println("Queue overflow");
            return;
        }
        q[r++] = id;
        size++;
    }

    String dequeue() {
        if (size == 0) {
            System.out.println("Queue underflow");
            return null;
        }
        size--;
        return q[f++];
    }

    boolean empty() {
        return size == 0;
    }
}
