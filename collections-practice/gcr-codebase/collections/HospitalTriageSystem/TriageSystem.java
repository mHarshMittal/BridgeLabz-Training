import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSystem {
    private PriorityQueue<Patient> patientQueue;
    
    public TriageSystem() {
        this.patientQueue = new PriorityQueue<>(new PatientComparator());
    }
    
    public void addPatient(Patient patient) {
        patientQueue.add(patient);
    }
    
    public Patient treatNextPatient() {
        return patientQueue.poll();
    }
    
    public static void main(String[] args) {
        TriageSystem triage = new TriageSystem();
        
        triage.addPatient(new Patient("John", 3));
        triage.addPatient(new Patient("Alice", 5));
        triage.addPatient(new Patient("Bob", 2));
        
        System.out.println("Treating patients in order:");
        Patient next = triage.treatNextPatient();
        while (next != null) {
            System.out.println("Treating: " + next);
            next = triage.treatNextPatient();
        }
    }
}
