class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName,
                      String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ticketId +
                ", Customer='" + customerName + '\'' +
                ", Movie='" + movieName + '\'' +
                ", Seat='" + seatNumber + '\'' +
                ", Time='" + bookingTime + '\'' +
                '}';
    }
}

class TicketCircularList {
    private TicketNode head = null;
    private TicketNode tail = null;

    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // circular link
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        // Case: only one node
        if (head == tail && head.ticketId == ticketId) {
            head = tail = null;
            System.out.println("Ticket removed.");
            return;
        }

        TicketNode curr = head;
        TicketNode prev = tail;

        do {
            if (curr.ticketId == ticketId) {
                prev.next = curr.next;

                if (curr == head) head = curr.next;
                if (curr == tail) tail = prev;

                System.out.println("Ticket removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode curr = head;
        System.out.println("Ticket List: ");
        do {
            System.out.println(curr);
            curr = curr.next;
        } while (curr != head);
    }

    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        TicketNode curr = head;

        do {
            if (curr.customerName.equalsIgnoreCase(key) ||
                curr.movieName.equalsIgnoreCase(key)) {
                System.out.println(curr);
                found = true;
            }
            curr = curr.next;
        } while (curr != head);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode curr = head;
        do {
            count++;
            curr = curr.next;
        } while (curr != head);

        return count;
    }
}


public class TicketReservationSystem {
    public static void main(String[] args) {

        TicketCircularList system = new TicketCircularList();

        system.addTicket(101, "Aman", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Riya", "Avatar", "B3", "10:05 AM");
        system.addTicket(103, "Kunal", "Inception", "C2", "10:10 AM");

        system.displayTickets();

        System.out.println("\nSearch by Movie: Inception");
        system.searchTicket("Inception");

        System.out.println("\nTotal Tickets: " + system.countTickets());

        system.removeTicket(102);
        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());
    }
}