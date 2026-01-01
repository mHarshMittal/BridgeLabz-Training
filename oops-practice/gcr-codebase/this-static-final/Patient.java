
public class Patient {
    // Static variable
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    
    // Final variable to ensure patient ID cannot be changed once assigned
    private final String patientID;
    private String name;
    private int age;
    private String ailment;
    
    public Patient(String name, String patientID, int age, String ailment) {
        this.name = name;
        this.patientID = patientID; 
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }
    
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    
    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient instance.");
        }
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPatientID() {
        return patientID;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getAilment() {
        return ailment;
    }
    
    public void setAilment(String ailment) {
        this.ailment = ailment;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create two patients
        Patient pat1 = new Patient("Rohan", "P001", 30, "Flu");
        Patient pat2 = new Patient("Sumit", "P002", 45, "Fracture");
        
        // Display total patients
        getTotalPatients();
        
        // Display patient details
        System.out.println();
        pat1.displayPatientDetails();
        System.out.println();
        pat2.displayPatientDetails();
    }
}

