import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String msg) {
        super(msg);
    }
}

class Table {
    boolean reserved = false;
}

class Reservation {
    int tableNo;
    String time;

    Reservation(int tableNo, String time) {
        this.tableNo = tableNo;
        this.time = time;
    }
}

class Restaurant {

    Map<Integer, Table> map = new HashMap<>();
    List<Reservation> list = new ArrayList<>();

    Restaurant(int n) {
        for (int i = 1; i <= n; i++)
            map.put(i, new Table());
    }

    void reserveTable(int t, String time) throws TableAlreadyReservedException {
        if (map.get(t).reserved)
            throw new TableAlreadyReservedException("Already Reserved");

        map.get(t).reserved = true;
        list.add(new Reservation(t, time));
    }

    void cancelReservation(int t) {
        map.get(t).reserved = false;
        list.removeIf(r -> r.tableNo == t);
    }

    void showAvailableTables() {
        for (int k : map.keySet())
            if (!map.get(k).reserved)
                System.out.println("Table " + k);
    }
}

public class RestaurantTable {
    public static void main(String[] args) {
        Restaurant r = new Restaurant(3);
        try {
            r.reserveTable(1, "6PM");
            r.reserveTable(1, "7PM"); // exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        r.showAvailableTables();
    }
}
