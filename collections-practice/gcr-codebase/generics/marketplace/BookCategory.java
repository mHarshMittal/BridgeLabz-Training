public enum BookCategory implements Category {
    FICTION, TECH, SCIENCE;

    @Override
    public String getCode() {
        return "BOOK_" + name();
    }
}

