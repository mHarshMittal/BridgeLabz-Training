public abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportID) {
        this.transportId = transportID;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }

    public GoodsTransport(String transportID, String transportDate, int transportRating) {
        this.transportId = transportID;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}