class ProductPrototype implements Cloneable {
    int price = 1000;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypeCloningApp {
    public static void main(String[] args) throws Exception {
        ProductPrototype p1 = new ProductPrototype();
        ProductPrototype p2 = (ProductPrototype) p1.clone();

        System.out.println("Original price: " + p1.price);
        System.out.println("Cloned price: " + p2.price);
    }
}
