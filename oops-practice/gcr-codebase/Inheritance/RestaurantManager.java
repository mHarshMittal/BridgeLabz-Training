// Interface
interface Worker {
    void performDuties();
}

// Base class
class Person {
    String name;
    int id;

    Person(String n, int i) {
        name = n;
        id = i;
    }
}

// Chef class
class Chef extends Person implements Worker {

    Chef(String n, int i) {
        super(n, i);
    }

    public void performDuties() {
        System.out.println("Chef cooks food");
    }
}

// Waiter class
class Waiter extends Person implements Worker {

    Waiter(String n, int i) {
        super(n, i);
    }

    public void performDuties() {
        System.out.println("Waiter serves food");
    }
}

// Test class
public class RestaurantManager {
    public static void main(String[] args) {
        Chef c = new Chef("Mukul", 1);
        Waiter w = new Waiter("Agraj", 2);

        c.performDuties();
        w.performDuties();
    }
}
