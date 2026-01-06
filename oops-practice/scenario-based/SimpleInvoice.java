public class SimpleInvoice {

    static String[] parseInvoice(String s) {
        return s.split(",");
    }

    static int getTotalAmount(String[] t) {
        int sum = 0;

        for (String x : t) {
            String[] p = x.split("-");
            String amt = p[1].replace("INR", "").trim();
            sum += Integer.parseInt(amt);
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "Logo Design - 3000 INR, Web Page - 4500 INR";

        String[] t = parseInvoice(s);
        int total = getTotalAmount(t);

        System.out.println("Total Amount: " + total + " INR");
    }
}
