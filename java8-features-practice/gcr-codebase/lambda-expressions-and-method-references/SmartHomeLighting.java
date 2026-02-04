package java8_features_practice.gcr_codebase.lambda_expressions_and_method_references;

@FunctionalInterface
interface Light {
	void activate();
}

class SmartLight {
	public void trigger(Light light) {
		light.activate();
	}
}

public class SmartHomeLighting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartLight smartLight = new SmartLight();
		Light motion = () -> System.out.println("Motion Light ON");
		Light morning = () -> System.out.println("Morning light ON");
		Light voice = () -> System.out.println("Voice command light ON");
		smartLight.trigger(motion);
		smartLight.trigger(morning);
		smartLight.trigger(morning);
	}

}
