import org.json.JSONObject;

public class CarToJSON {

    String brand;
    int year;

    CarToJSON(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public static void main(String[] args) {

        CarToJSON car = new CarToJSON("Toyota", 2022);

        JSONObject json = new JSONObject();
        json.put("brand", car.brand);
        json.put("year", car.year);

        System.out.println(json);
    }
}
