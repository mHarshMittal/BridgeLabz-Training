import java.util.*;

// Custom Exception
class InsufficientResourceException extends Exception {
    public InsufficientResourceException(String message) {
        super(message);
    }
}

// Area Request class
class AreaRequest {
    private String areaName;
    private String resourceType;
    private int quantity;

    public AreaRequest(String areaName, String resourceType, int quantity) {
        this.areaName = areaName;
        this.resourceType = resourceType;
        this.quantity = quantity;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Relief Center class
class ReliefCenter {
    private String centerName;
    private HashMap<String, Integer> resources = new HashMap<>();

    public ReliefCenter(String centerName) {
        this.centerName = centerName;
    }

    public void addResource(String item, int quantity) {
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }

    public void allocateResource(String item, int quantity) throws InsufficientResourceException {
        int available = resources.getOrDefault(item, 0);

        if (available < quantity) {
            throw new InsufficientResourceException("Not enough " + item + " in " + centerName);
        }

        resources.put(item, available - quantity);
    }

    public int getResourceQuantity(String item) {
        return resources.getOrDefault(item, 0);
    }
}

// Main System
public class DisasterReliefSystem {

    public static void main(String[] args) {

        // Map of Relief Centers
        Map<String, ReliefCenter> centers = new HashMap<>();

        ReliefCenter rc1 = new ReliefCenter("Center1");
        rc1.addResource("Food", 100);
        rc1.addResource("Water", 200);
        rc1.addResource("Medicine", 50);

        centers.put("RC1", rc1);

        //  Queue of Area Requests (FIFO)
        Queue<AreaRequest> requests = new LinkedList<>();
        requests.add(new AreaRequest("AreaA", "Food", 30));
        requests.add(new AreaRequest("AreaB", "Water", 50));
        requests.add(new AreaRequest("AreaC", "Medicine", 60)); // will fail

        
        while (!requests.isEmpty()) {
            AreaRequest req = requests.poll(); // FIFO

            try {
                ReliefCenter center = centers.get("RC1");
                center.allocateResource(req.getResourceType(), req.getQuantity());

                
                System.out.println("Allocated " + req.getQuantity() + " of "
                        + req.getResourceType() + " to " + req.getAreaName());
                System.out.println("Remaining stock: "
                        + center.getResourceQuantity(req.getResourceType()));
                System.out.println("------------------------");

            } catch (InsufficientResourceException e) {
                System.out.println("Allocation Failed for " + req.getAreaName());
                System.out.println(e.getMessage());
                System.out.println("------------------------");
            }
        }
    }
}
