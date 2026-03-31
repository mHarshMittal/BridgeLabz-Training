public class UnitConverter {

    public static double kmToMiles(double km) { return km * 0.621371; }
    public static double milesToKm(double miles) { return miles * 1.60934; }
    public static double metersToFeet(double meters) { return meters * 3.28084; }
    public static double feettoMeters(double feet) { return feet * 0.3048; }

    public static void main(String[] args) {
        System.out.println("10 km to miles: " + kmToMiles(10));
        System.out.println("6 miles to km: " + milesToKm(6));
        System.out.println("1 meter to feet: " + metersToFeet(1));
        System.out.println("3 feet to meters: " + feettoMeters(3));
    }
}