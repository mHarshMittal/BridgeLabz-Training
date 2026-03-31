public enum ClothingCategory implements Category {
    MENS, WOMENS, KIDS;

    @Override
    public String getCode() {
        return "CLOTH_" + name();
    }
}

