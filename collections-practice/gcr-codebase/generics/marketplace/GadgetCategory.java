public enum GadgetCategory implements Category {
    PHONE, LAPTOP, ACCESSORY;

    @Override
    public String getCode() {
        return "GADGET_" + name();
    }
}

