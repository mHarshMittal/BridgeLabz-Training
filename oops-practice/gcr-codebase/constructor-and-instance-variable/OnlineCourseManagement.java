package oops_practice.gcr_codebase.constructors_and_instance_variables;
class Course{
	private String courseName;
	private int duration;
	private double fee;
	private static String instituteName = "GLA University";
	
	Course(){
		this("Unknown", 0, 0.0);
	}
	
	Course(String courseName, int duration, double fee){
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}
	
	void displayCourseDetails() {
		System.out.println("Course Name: " + courseName + ", Duration: " + duration + " hrs, Fee: " + fee + ", Institute Name: " + instituteName);
	}
	
	void updateInstituteName(String instituteName) {
		Course.instituteName = instituteName;
	}
}
public class OnlineCourseManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course c1 = new Course();
		Course c2 = new Course("CSE", 500, 1200000);
		c1.displayCourseDetails();
		c2.displayCourseDetails();
		c1.updateInstituteName("GLA");
		c1.displayCourseDetails();
		c2.displayCourseDetails();
	}

}
