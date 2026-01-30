/*
  10. Validate an IPv4 address - four groups of numbers (0-255) separated by dots.
 */
public class ValidateIpAddress {

    public static boolean isValidIpAddress(String ip) {
        if (ip == null) return false;
        String octet = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        return ip.matches("^(" + octet + "\\.){3}" + octet + "$");
    }

    public static void main(String[] args) {
        System.out.println("192.168.1.1: " + (isValidIpAddress("192.168.1.1") ? "Valid" : "Invalid"));
        System.out.println("256.1.1.1: " + (isValidIpAddress("256.1.1.1") ? "Valid" : "Invalid"));
    }
}
