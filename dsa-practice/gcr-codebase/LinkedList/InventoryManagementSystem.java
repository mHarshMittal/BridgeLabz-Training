class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    @Override
    public String toString() {
        return itemId + " | " + itemName + " | Qty: " + quantity + " | Price: " + price;
    }
}

class InventoryList {
    private ItemNode head;
    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode node = new ItemNode(id, name, qty, price);
        node.next = head;
        head = node;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode node = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = node;
            return;
        }

        ItemNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode curr = head;
        int index = 0;

        while (curr.next != null && index < pos - 1) {
            curr = curr.next;
            index++;
        }

        ItemNode node = new ItemNode(id, name, qty, price);
        node.next = curr.next;
        curr.next = node;
    }


    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        ItemNode prev = head;
        ItemNode curr = head.next;

        while (curr != null) {
            if (curr.itemId == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }


    public void updateQuantity(int id, int newQty) {
        ItemNode curr = head;

        while (curr != null) {
            if (curr.itemId == id) {
                curr.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            curr = curr.next;
        }

        System.out.println("Item not found.");
    }


    public ItemNode searchById(int id) {
        ItemNode curr = head;

        while (curr != null) {
            if (curr.itemId == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    public ItemNode searchByName(String name) {
        ItemNode curr = head;

        while (curr != null) {
            if (curr.itemName.equalsIgnoreCase(name)) return curr;
            curr = curr.next;
        }
        return null;
    }


    public double calculateTotalValue() {
        double total = 0;
        ItemNode curr = head;

        while (curr != null) {
            total += curr.price * curr.quantity;
            curr = curr.next;
        }
        return total;
    }


    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    private ItemNode mergeSort(ItemNode h, boolean byName, boolean ascending) {
        if (h == null || h.next == null) return h;

        ItemNode mid = getMiddle(h);
        ItemNode nextMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(h, byName, ascending);
        ItemNode right = mergeSort(nextMid, byName, ascending);

        return merge(left, right, byName, ascending);
    }

    private ItemNode merge(ItemNode a, ItemNode b, boolean byName, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;

        if (byName) {
            condition = ascending
                    ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                    : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending
                    ? a.price <= b.price
                    : a.price > b.price;
        }

        ItemNode result;
        if (condition) {
            result = a;
            result.next = merge(a.next, b, byName, ascending);
        } else {
            result = b;
            result.next = merge(a, b.next, byName, ascending);
        }

        return result;
    }

    private ItemNode getMiddle(ItemNode h) {
        if (h == null) return h;

        ItemNode slow = h;
        ItemNode fast = h.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        ItemNode curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }
}


public class InventoryManagementSystem {
    public static void main(String[] args) {

        InventoryList inv = new InventoryList();
        inv.addAtEnd(101, "Laptop", 5, 50000);
        inv.addAtEnd(102, "Mouse", 20, 500);
        inv.addAtBeginning(103, "Keyboard", 10, 1500);
        inv.addAtPosition(1, 104, "Monitor", 7, 12000);

        System.out.println("\nInventory:");
        inv.displayAll();

        System.out.println("\nSearch by ID 102:");
        System.out.println(inv.searchById(102));

        System.out.println("\nSearch by Name 'Laptop':");
        System.out.println(inv.searchByName("Laptop"));

        inv.updateQuantity(101, 8);

        System.out.println("\nTotal Inventory Value: " + inv.calculateTotalValue());

        System.out.println("\nSort by Name Ascending:");
        inv.sortByName(true);
        inv.displayAll();

        System.out.println("\nSort by Price Descending:");
        inv.sortByPrice(false);
        inv.displayAll();

        inv.removeById(103);

        System.out.println("\nAfter Deletion:");
        inv.displayAll();
    }
}