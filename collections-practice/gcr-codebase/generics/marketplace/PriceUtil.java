
public final class PriceUtil {
    private PriceUtil() {}

    public static <P extends Product<?>> void applyDiscount(P product, double percent) {
        if (percent <= 0) return;
        double price = product.getPrice();
        double cut = price * (percent / 100.0);
        product.setPrice(price - cut);
    }
}

