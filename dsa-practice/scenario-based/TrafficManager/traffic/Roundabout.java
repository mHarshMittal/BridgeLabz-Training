package traffic;

class Roundabout {
    private Vehicle head;

    void add(String id) {
        Vehicle v = new Vehicle(id);
        if (head == null) {
            head = v;
            v.next = v;
            return;
        }

        Vehicle t = head;
        while (t.next != head) t = t.next;
        t.next = v;
        v.next = head;
    }

    void remove(String id) {
        if (head == null) return;

        Vehicle curr = head, prev = null;
        do {
            if (curr.id.equals(id)) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) head = head.next;
                    if (prev != null) prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void print() {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        Vehicle t = head;
        do {
            System.out.print(t.id + " -> ");
            t = t.next;
        } while (t != head);
        System.out.println("(back)");
    }
}
