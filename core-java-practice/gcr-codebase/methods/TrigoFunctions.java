public class TrigoFunctions {
    public static double[] calcTrigonocFun(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{
            Math.sin(radians),
            Math.cos(radians),
            Math.tan(radians)
        };
    }

    public static void main(String[] args) {
        double angle = 45.0;
        double[] results = calcTrigonocFun(angle);
        System.out.printf("Sine: %.4f, Cosine: %.4f, Tangent: %.4f%n", results[0], results[1], results[2]);
    }
}