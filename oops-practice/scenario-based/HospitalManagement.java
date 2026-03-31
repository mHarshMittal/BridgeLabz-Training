/*Hospital Patient Management System (CRUD)
● Concepts: Patient, Doctor, Bill classes.
● OOP: Encapsulation (Properties), Abstraction (Interface IPayable), Inheritance
(InPatient, OutPatient : Patient), Polymorphism (DisplayInfo). */

interface IPayable {
    double calculateBill();
}

//Patient class
class Patient {
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation using getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Polymorphic method
    public void displayInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient class inherits Patient
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    // Bill calculation for Inpatient
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Method overriding (Polymorphism)
    public void displayInfo(){
        super.displayInfo();                                                                       
        System.out.println("Patient Type: InPatient");
        System.out.println("Total Bill: " + calculateBill());
    }
}

// OutPatient class inherits Patient
class OutPatient extends Patient implements IPayable {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Type: OutPatient");
        System.out.println("Total Bill: " + calculateBill());
    }
}

// Doctor class
class Doctor {
    
    private String doctorName;
    private String specialization;
    
                            
    public Doctor(String doctorName, String specialization) {
        
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public void displayDoctor() {
        System.out.println("Doctor: " + doctorName + " (" + specialization + ")");
    }
}

// Main class
public class HospitalManagement {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Sharma", "Cardiology");

        Patient p1 = new InPatient(101, "Pooja", 18, 5, 2000);
        Patient p2 = new OutPatient(102, "Vishu", 20, 500);

        doctor.displayDoctor();
        System.out.println("------------------------");
        p1.displayInfo();
        System.out.println("------------------------");
        p2.displayInfo();
    }
}




