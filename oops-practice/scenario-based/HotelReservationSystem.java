import java.time.LocalDate;
import java.util.*;

// Basic hotel reservation with seasonal pricing.
public class HotelReservationSystem {
    public static void main(String[] args) {
        PricingStrategy normal = nights -> nights * 2000;
        PricingStrategy seasonal = nights -> nights * 2600;

        Hotel hotel = new Hotel(normal);
        hotel.addRoom(new DeluxeRoom("R1"));
        hotel.addRoom(new StandardRoom("R2"));

        Reservation res = hotel.book("R1", new Guest("G1", "Ishaan"), LocalDate.now(), LocalDate.now().plusDays(2));
        System.out.println("Invoice: " + res.generateInvoice());

        hotel.setPricingStrategy(seasonal);
        Reservation res2 = hotel.book("R2", new Guest("G2", "Seema"), LocalDate.now(), LocalDate.now().plusDays(3));
        System.out.println("Seasonal invoice: " + res2.generateInvoice());
    }
}

abstract class Room {
    private final String id;
    private boolean reserved;

    protected Room(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String id) {
        super(id);
    }
}

class StandardRoom extends Room {
    StandardRoom(String id) {
        super(id);
    }
}

class Guest {
    private final String id;
    private final String name;

    Guest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Reservation {
    private final Room room;
    private final Guest guest;
    private final LocalDate from;
    private final LocalDate to;
    private final PricingStrategy pricingStrategy;

    Reservation(Room room, Guest guest, LocalDate from, LocalDate to, PricingStrategy pricingStrategy) {
        this.room = room;
        this.guest = guest;
        this.from = from;
        this.to = to;
        this.pricingStrategy = pricingStrategy;
    }

    public double generateInvoice() {
        long nights = from.until(to).getDays();
        return pricingStrategy.calculate(nights);
    }
}

interface PricingStrategy {
    double calculate(long nights);
}

class RoomNotAvailableException extends RuntimeException {
    RoomNotAvailableException(String msg) {
        super(msg);
    }
}

class Hotel {
    private final Map<String, Room> rooms = new HashMap<>();
    private PricingStrategy pricingStrategy;

    Hotel(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    Reservation book(String roomId, Guest guest, LocalDate from, LocalDate to) {
        Room room = requireRoom(roomId);
        if (room.isReserved()) {
            throw new RoomNotAvailableException("Room busy");
        }
        room.setReserved(true);
        Reservation reservation = new Reservation(room, guest, from, to, pricingStrategy);
        return reservation;
    }

    void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    private Room requireRoom(String id) {
        Room room = rooms.get(id);
        if (room == null) {
            throw new IllegalArgumentException("Room missing " + id);
        }
        return room;
    }
}

