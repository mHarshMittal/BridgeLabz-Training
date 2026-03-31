import java.util.*;

// Custom Exception
class SensorFailureException extends Exception {
    public SensorFailureException(String msg) {
        super(msg);
    }
}

// Temperature log for one room
class TemperatureLog {
    private List<Double> dailyReadings = new ArrayList<>();

    public void addReading(double temp) {
        dailyReadings.add(temp);
    }

    public List<Double> getDailyReadings() {
        return dailyReadings;
    }

    public double getAverage() {
        double sum = 0;
        for (double t : dailyReadings) {
            sum += t;
        }
        return dailyReadings.isEmpty() ? 0 : sum / dailyReadings.size();
    }
}

// Main Monitor System
public class ColdStorageMonitor {

    private Map<String, TemperatureLog> roomMap = new HashMap<>();
    private double minSafeTemp = 2.0;
    private double maxSafeTemp = 8.0;

    public void addRoom(String roomId) {
        roomMap.put(roomId, new TemperatureLog());
    }

    public void recordTemperature(String roomId, Double temp) throws SensorFailureException {
        if (temp == null || temp < -50 || temp > 50) {
            throw new SensorFailureException("Sensor failure in room " + roomId);
        }

        TemperatureLog log = roomMap.get(roomId);
        if (log == null) {
            log = new TemperatureLog();
            roomMap.put(roomId, log);
        }

        log.addReading(temp);

        if (temp < minSafeTemp || temp > maxSafeTemp) {
            System.out.println("ALERT: Room " + roomId + " out of safe range: " + temp);
        }
    }

    public void printDailyAverage() {
        for (String roomId : roomMap.keySet()) {
            TemperatureLog log = roomMap.get(roomId);
            System.out.println("Room " + roomId + " Average: " + log.getAverage());
        }
    }

    public static void main(String[] args) {
        ColdStorageMonitor monitor = new ColdStorageMonitor();

        monitor.addRoom("R1");
        monitor.addRoom("R2");

        try {
            monitor.recordTemperature("R1", 4.0);
            monitor.recordTemperature("R1", 6.0);
            monitor.recordTemperature("R1", 9.0); // alert

            monitor.recordTemperature("R2", 3.0);
            monitor.recordTemperature("R2", null); // exception
        } catch (SensorFailureException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nDaily Averages:");
        monitor.printDailyAverage();
    }
}