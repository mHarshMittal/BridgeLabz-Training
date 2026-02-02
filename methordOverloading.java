
class MethodOverloading {

    // two int
    void show(int a, int b) {
        System.out.println("Two integers: " + (a + b));
    }

    // two double

    void show(double a, double b) {
        System.out.println("Two doubles: " + (a + b));
    }

    // int and String
    void show(int a, String b) {
        System.out.println("Integer and String: " + a + " " + b);
    }

    public static void main(String[] args) {

        MethodOverloading obj = new MethodOverloading();

        obj.show(10, 20);
        obj.show(5.5, 4.5);
        obj.show(100, "Harsh");

    }
}
