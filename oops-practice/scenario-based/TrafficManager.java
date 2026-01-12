import java.util.*;

// Circular linked list for vehicles in roundabout plus entry queue.
public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout(5);
        roundabout.enqueueIncoming("Car-1");
        roundabout.enqueueIncoming("Car-2");
        roundabout.enqueueIncoming("Car-3");

        roundabout.allowEntry();
        roundabout.allowEntry();
        roundabout.removeFromCircle("Car-1");
        roundabout.printState();
    }
}

class VehicleNode {
    final String plate;
    VehicleNode next;

    VehicleNode(String plate) {
        this.plate = plate;
    }
}

class Roundabout {
    private VehicleNode head;
    private int size;
    private final int capacity;
    private final Queue<String> waitingQueue = new ArrayDeque<>();
    private final int queueLimit = 10;

    Roundabout(int capacity) {
        this.capacity = capacity;
    }

    void enqueueIncoming(String plate) {
        if (waitingQueue.size() >= queueLimit) {
            throw new IllegalStateException("Queue overflow");
        }
        waitingQueue.add(plate);
    }

    void allowEntry() {
        if (waitingQueue.isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        if (size >= capacity) {
            throw new IllegalStateException("Roundabout full");
        }
        String plate = waitingQueue.poll();
        addToCircle(plate);
    }

    private void addToCircle(String plate) {
        VehicleNode node = new VehicleNode(plate);
        if (head == null) {
            head = node;
            node.next = node;
        } else {
            VehicleNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = node;
            node.next = head;
        }
        size++;
    }

    void removeFromCircle(String plate) {
        if (head == null) {
            return;
        }
        VehicleNode current = head;
        VehicleNode previous = null;
        do {
            if (current.plate.equals(plate)) {
                if (previous == null) { // removing head
                    if (current.next == head) {
                        head = null;
                    } else {
                        VehicleNode tail = head;
                        while (tail.next != head) {
                            tail = tail.next;
                        }
                        head = current.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    void printState() {
        System.out.println("Roundabout size: " + size);
        if (head == null) {
            System.out.println("No vehicles in circle");
            return;
        }
        VehicleNode current = head;
        do {
            System.out.print(current.plate + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to start)");
        System.out.println("Waiting queue: " + waitingQueue);
    }
}

