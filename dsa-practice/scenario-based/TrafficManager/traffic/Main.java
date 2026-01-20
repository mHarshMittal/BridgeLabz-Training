package traffic;

public class Main {
    public static void main(String[] args) {

        Roundabout r = new Roundabout();
        VehicleQueue q = new VehicleQueue(2);

        q.enqueue("A1");
        q.enqueue("B2");
        q.enqueue("C3");   // overflow

        while (!q.empty()) {
            r.add(q.dequeue());
        }

        r.print();

        r.remove("A1");
        r.print();
    }
}

