
public class Product<T extends Category> {
    private final String name;
    private final T category;
    private double price;

    public Product(String name, T category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category.getCode() + ") - " + price;
    }
}

