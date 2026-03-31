interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    // sensitive data (encapsulated)
    private String diagnosis;
    private String medicalHistory;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // setters for sensitive data
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // protected access for subclasses
    protected String getDiagnosis() {
        return diagnosis;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // concrete method
    public String getPatientDetails() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }

    // abstract billing method
    public abstract double calculateBill();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        setMedicalHistory(record);
    }

    public void viewRecords() {
        System.out.println("Medical History: " + getMedicalHistory());
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        setMedicalHistory(record);
    }

    public void viewRecords() {
        System.out.println("Medical History: " + getMedicalHistory());
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

// Polymorphic billing handler
class HospitalBilling {

    public static void generateBill(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: " + patient.calculateBill());
        System.out.println("--------------------------------");
    }
}

// Main class
public class HospitalManagementSystem {

    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Rahul", 35, 5, 2000);
        p1.setDiagnosis("Pneumonia");
        ((MedicalRecord) p1).addRecord("Admitted with breathing issues");

        Patient p2 = new OutPatient(102, "Anita", 28, 500);
        p2.setDiagnosis("Fever");
        ((MedicalRecord) p2).addRecord("Prescribed medication");

        HospitalBilling.generateBill(p1);
        HospitalBilling.generateBill(p2);
    }
}

