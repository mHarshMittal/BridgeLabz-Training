import java.util.*;

class Train implements Comparable<Train> {
    int trainNo;
    int arrivalTime;
    int departureTime;

    public Train(int trainNo, int arrivalTime, int departureTime) {
        this.trainNo = trainNo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public int compareTo(Train t) {
        return this.arrivalTime - t.arrivalTime;
    }
}

class Platform {
    int platformNo;
    boolean isAvailable = true;

    public Platform(int platformNo) {
        this.platformNo = platformNo;
    }
}

class PlatformUnavailableException extends Exception {
    public PlatformUnavailableException(String msg) {
        super(msg);
    }
}

class RailwayStation {
    Map<Integer, Platform> platformMap = new HashMap<>();
    PriorityQueue<Train> trainQueue = new PriorityQueue<>();

    public RailwayStation(int totalPlatforms) {
        for (int i = 1; i <= totalPlatforms; i++) {
            platformMap.put(i, new Platform(i));
        }
    }

    public void addTrain(Train t) {
        trainQueue.offer(t);
    }

    public void allocatePlatforms() throws PlatformUnavailableException {
        while (!trainQueue.isEmpty()) {
            Train t = trainQueue.poll();
            Platform p = getNearestAvailablePlatform();

            if (p == null) {
                throw new PlatformUnavailableException(
                        "No platform available for Train " + t.trainNo);
            }

            p.isAvailable = false;
            System.out.println("Train " + t.trainNo + " allocated Platform " + p.platformNo);
        }
    }

    private Platform getNearestAvailablePlatform() {
        for (int i = 1; i <= platformMap.size(); i++) {
            Platform p = platformMap.get(i);
            if (p.isAvailable) {
                return p;
            }
        }
        return null;
    }
}

public class RailwayStationManagement {
    public static void main(String[] args) {
        RailwayStation station = new RailwayStation(2);

        station.addTrain(new Train(101, 5, 10));
        station.addTrain(new Train(102, 3, 8));
        station.addTrain(new Train(103, 4, 9));

        try {
            station.allocatePlatforms();
        } catch (PlatformUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
}