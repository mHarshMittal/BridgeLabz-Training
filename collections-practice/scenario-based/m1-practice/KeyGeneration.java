
import java.util.*;

public class KeyGeneration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			str = str.trim();

			if (str.isEmpty()) {
				System.out.println("Invalid Input (empty string)");
			} else if (str.length() < 6) {
				System.out.println("Invalid Input (length < 6)");
			} else if (str.matches(".*\\d.*")) {
				System.out.println("Invalid Input (contains digits)");
			} else if (str.contains(" ")) {
				System.out.println("Invalid Input (contains space)");
			} else if (!str.matches("[a-zA-Z]+")) {
				System.out.println("Invalid Input (contains special character)");
			} else {
				String key = generateKey(str);
				System.out.println("The generated key is - " + key);
			}
		}
		sc.close();
	}

	private static String generateKey(String str) {
		str = str.toLowerCase();
		StringBuilder filtered = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if ((int) ch % 2 != 0) {
				filtered.append(ch);
			}
		}
		filtered.reverse();
		for (int i = 0; i < filtered.length(); i++) {
			if (i % 2 == 0) {
				filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
			}
		}
		return filtered.toString();
	}
}