package java8_features_practice.gcr_codebase.lambda_expressions_and_method_references;

import java.util.Arrays;
import java.util.List;

class Patient {
	private int id;
	private String name;

	Patient(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

public class PatientId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Patient> list = Arrays.asList(new Patient(1, "Govind"), new Patient(2, "Hariom"), new Patient(3, "Akash"));
		list.stream().map(Patient::getId).forEach(System.out::println);
	}

}
