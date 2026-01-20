import java.util.List;


public final class WarehouseView {
    private WarehouseView() {}

    public static void showAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item);
        }
    }
}

