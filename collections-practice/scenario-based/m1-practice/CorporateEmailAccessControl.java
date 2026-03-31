
import java.util.*;
import java.util.regex.*;

public class CorporateEmailAccessControl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String pattern = "^([a-z]{3,})\\.([a-z]{3,})([0-9]{4,})@(sales|marketing|IT|product)\\.company\\.com$";
		Pattern p = Pattern.compile(pattern);
		for (int i = 0; i < N; i++) {
			String email = sc.nextLine().trim();
			Matcher m = p.matcher(email);
			if (m.matches()) {
				System.out.println("Access Granted");
			} else {
				System.out.println("Access Denied");
			}
		}
		sc.close();
	}
}

