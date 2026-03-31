
import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.*;

public class DynamicTemplateProcessor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		Pattern placeholderPattern = Pattern.compile("\\$\\{(\\w+):([^}]+)\\}");

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			Matcher matcher = placeholderPattern.matcher(line);
			StringBuffer result = new StringBuffer();

			while (matcher.find()) {
				String type = matcher.group(1);
				String value = matcher.group(2);
				String replacement;

				switch (type) {
				case "DATE":
					replacement = processDate(value);
					break;
				case "UPPER":
					replacement = value.toUpperCase();
					break;
				case "LOWER":
					replacement = value.toLowerCase();
					break;
				case "REPEAT":
					replacement = processRepeat(value);
					break;
				default:
					replacement = "INVALID";
				}

				matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
			}

			matcher.appendTail(result);
			System.out.println(result.toString());
		}

		sc.close();
	}

	private static String processDate(String value) {
		try {
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate date = LocalDate.parse(value, inputFormat);
			return date.format(outputFormat);
		} catch (DateTimeParseException e) {
			return "INVALID";
		}
	}

	private static String processRepeat(String value) {
		String[] parts = value.split(",");
		if (parts.length != 2)
			return "INVALID";
		String word = parts[0];
		try {
			int count = Integer.parseInt(parts[1]);
			if (count < 0)
				return "INVALID";
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++)
				sb.append(word);
			return sb.toString();
		} catch (NumberFormatException e) {
			return "INVALID";
		}
	}
}