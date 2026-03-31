import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Car {
    String brand;
    int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}

public class ConvertListToJSONArray {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", 2020));
        cars.add(new Car("Honda", 2021));
        cars.add(new Car("Ford", 2022));

        JSONArray jsonArray = new JSONArray();

        for (Car car : cars) {
            JSONObject json = new JSONObject();
            json.put("brand", car.brand);
            json.put("year", car.year);
            jsonArray.put(json);
        }

        System.out.println(jsonArray);
    }
}
