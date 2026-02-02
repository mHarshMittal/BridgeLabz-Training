// Define the structure 
public class CircularLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // add other new node in linked list

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;
            tail = newNode;
            tail.next = head; // Because circular
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty, please enter the element in Linked List.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();

    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

       cll.add(1);
       cll.add(2);
       cll.add(10);
       cll.add(23);
       cll.add(55);

        System.out.println("Circular Linked List:");
        cll.display();
    }
}