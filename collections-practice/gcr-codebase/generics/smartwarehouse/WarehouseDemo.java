public class WarehouseDemo {
    public static void main(String[] args) {
        Storage<ElectronicsItem> elecStore = new Storage<>();
        elecStore.add(new ElectronicsItem("Laptop"));
        elecStore.add(new ElectronicsItem("Phone"));

        Storage<GroceryItem> foodStore = new Storage<>();
        foodStore.add(new GroceryItem("Apples"));
        foodStore.add(new GroceryItem("Milk"));

        System.out.println("Electronics:");
        WarehouseView.showAll(elecStore.asList());

        System.out.println("Groceries:");
        WarehouseView.showAll(foodStore.asList());
    }
}

