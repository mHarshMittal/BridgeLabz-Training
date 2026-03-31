public class MarketDemo {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Basics", BookCategory.TECH, 500.0);
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", ClothingCategory.MENS, 800.0);
        Product<GadgetCategory> phone = new Product<>("Smart Phone", GadgetCategory.PHONE, 15000.0);

        System.out.println("Before discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        PriceUtil.applyDiscount(book, 10.0);
        PriceUtil.applyDiscount(shirt, 5.0);
        PriceUtil.applyDiscount(phone, 15.0);

        System.out.println("After discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}

