package java8_features_practice.gcr_codebase.lambda_expressions_and_method_references;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Alert {
	private String type;
	private int priority;

	public Alert(String type, int priority) {
		this.type = type;
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return type + " " + priority;
	}
}

public class NotificationFiltering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alert> alerts = Arrays.asList(new Alert("EMERGENCY", 1), new Alert("MEDICATION", 2),
				new Alert("APPOINTMENT", 3), new Alert("EMERGENCY", 2), new Alert("APPOINTMENT", 2));
		Predicate<Alert> emergency = alert -> alert.getType().equals("EMERGENCY");
		Predicate<Alert> appointment = alert -> alert.getType().equals("APPOINTMENT");
		Predicate<Alert> medication = alert -> alert.getType().equals("MEDICATION");
		Predicate<Alert> highPriority = alert -> alert.getPriority() == 1;
		Predicate<Alert> medPriority = alert -> alert.getPriority() == 2;
		Predicate<Alert> lowPriority = alert -> alert.getPriority() == 3;
		alerts.stream().filter(emergency).forEach(System.out::println);
		System.out.println();
		alerts.stream().filter(appointment).forEach(System.out::println);
		System.out.println();
		alerts.stream().filter(medication).forEach(System.out::println);
		System.out.println();
		alerts.stream().filter(highPriority).forEach(System.out::println);
		System.out.println();
		alerts.stream().filter(medPriority).forEach(System.out::println);
		System.out.println();
		alerts.stream().filter(lowPriority).forEach(System.out::println);
	}

}
