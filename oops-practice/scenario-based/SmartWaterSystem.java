import java.util.*;

// Exception 
class InvalidWaterLevelException extends Exception {
    public InvalidWaterLevelException(String msg) {
        super(msg);
    }
}

// WaterTank class created
class WaterTank {
    String id;
    int capacity;
    int currentLevel;

    WaterTank(String id, int capacity, int currentLevel) throws InvalidWaterLevelException {
        if (currentLevel > capacity) {
            throw new InvalidWaterLevelException("Level exceeds capacity for tank " + id);
        }
        this.id = id;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    double getPercentage() {
        return (currentLevel * 100.0) / capacity;
    }
}

public class SmartWaterSystem {

    public static void main(String[] args) {

        List<WaterTank> tanks = new ArrayList<>();

        try {
            tanks.add(new WaterTank("T1", 1000, 150));
            tanks.add(new WaterTank("T2", 800, 600));
            tanks.add(new WaterTank("T3", 500, 50));
        } catch (InvalidWaterLevelException e) {
            System.out.println(e.getMessage());
        }

        // Alert check
        for (WaterTank t : tanks) {
            System.out.println("Tank " + t.id + " : " + t.getPercentage() + "%");

            if (t.getPercentage() < 20) {
                System.out.println("ALERT: Water low in tank " + t.id);
            }
        }

        System.out.println("---- Sorted by lowest level ----");

        // Sort by lowest current level
        Collections.sort(tanks, new Comparator<WaterTank>() {
            public int compare(WaterTank a, WaterTank b) {
                return a.currentLevel - b.currentLevel;
            }
        });

        for (WaterTank t : tanks) {
            System.out.println(t.id + " -> " + t.currentLevel);
        }
    }
}
