

import java.util.regex.*;
import java.util.Scanner;

class GlobalShipmentManifest {
	private static final String SHIP_CODE_REGEX = "SHIP-(?!0)(\\d)(?!\\1{3})\\d{5}";
	private static final String MODE_REGEX = "AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT";
	private static final String WEIGHT_REGEX = "([1-9]\\d{0,5}(\\.\\d{1,2})?|0(\\.\\d{1,2})?)";
	private static final String STATUS_REGEX = "DELIVERED|CANCELLED|IN_TRANSIT";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String record = sc.nextLine();
			if (isValidRecord(record)) {
				System.out.println("COMPLIANT RECORD");
			} else {
				System.out.println("NON-COMPLIANT RECORD");
			}
		}

		sc.close();
	}

	private static boolean isValidRecord(String record) {
		String[] parts = record.split("\\|");
		if (parts.length != 5) {
			return false;
		}

		String code = parts[0];
		String date = parts[1];
		String mode = parts[2];
		String weight = parts[3];
		String status = parts[4];
		if (!Pattern.matches(SHIP_CODE_REGEX, code))
			return false;

		if (!isValidDate(date))
			return false;

		if (!Pattern.matches(MODE_REGEX, mode))
			return false;

		if (!Pattern.matches(WEIGHT_REGEX, weight))
			return false;

		if (!Pattern.matches(STATUS_REGEX, status))
			return false;

		return true;
	}

	private static boolean isValidDate(String date) {
		String[] parts = date.split("-");
		if (parts.length != 3)
			return false;

		try {
			int year = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int day = Integer.parseInt(parts[2]);

			if (year < 2000 || year > 2099)
				return false;
			if (month < 1 || month > 12)
				return false;
			int[] daysInMonth = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			return day >= 1 && day <= daysInMonth[month - 1];
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}