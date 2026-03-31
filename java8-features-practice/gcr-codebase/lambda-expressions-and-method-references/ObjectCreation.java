package java8_features_practice.gcr_codebase.lambda_expressions_and_method_references;

import java.util.List;

class Invoice {
	private String id;

	Invoice(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Transaction ID: " + id;
	}
}

public class ObjectCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ids = List.of("A123", "B456", "C789");
		List<Invoice> invoices = ids.stream().map(Invoice::new).toList();
		invoices.forEach(System.out::println);
	}

}
