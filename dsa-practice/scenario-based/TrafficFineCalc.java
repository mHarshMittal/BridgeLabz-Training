import java.util.*;

class InvalidVehicleException extends Exception {
    public InvalidVehicleException(String msg) {
        super(msg);
    }
}

abstract class Violation {
    abstract double getFine();
}

class Speeding extends Violation {
    public double getFine() {
        return 1000;
    }
}

class SignalJump extends Violation {
    public double getFine() {
        return 1500;
    }
}

class NoHelmet extends Violation {
    public double getFine() {
        return 500;
    }
}

class TrafficSystem {
    Map<String, List<Violation>> records = new HashMap<>();

    public void addViolation(String vehicleNo, Violation v) throws InvalidVehicleException {
        if (vehicleNo == null || vehicleNo.length() < 6) {
            throw new InvalidVehicleException("Invalid Vehicle Number");
        }
        records.putIfAbsent(vehicleNo, new ArrayList<>());
        records.get(vehicleNo).add(v);
    }

    public double calculateFine(String vehicleNo) {
        List<Violation> list = records.get(vehicleNo);
        double total = 0;
        for (Violation v : list) {
            total += v.getFine();
        }
        if (list.size() > 3) {
            total += 500; // extra penalty
        }
        return total;
    }

    public void generateMonthlyReport() {
        for (String vehicle : records.keySet()) {
            System.out.println("Vehicle: " + vehicle);
            System.out.println("Violations: " + records.get(vehicle).size());
            System.out.println("Total Fine: " + calculateFine(vehicle));
            System.out.println("------------------");
        }
    }
}

public class TrafficFineCalc {
    public static void main(String[] args) throws Exception {
        TrafficSystem ts = new TrafficSystem();

        ts.addViolation("UP32AB1234", new Speeding());
        ts.addViolation("UP32AB1234", new SignalJump());
        ts.addViolation("UP32AB1234", new NoHelmet());
        ts.addViolation("UP32AB1234", new Speeding());

        ts.addViolation("DL01CD5678", new NoHelmet());

        ts.generateMonthlyReport();
    }
}