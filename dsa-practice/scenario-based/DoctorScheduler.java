import java.util.*;

// Custom Exception
class SlotUnavailableException extends Exception {
    public SlotUnavailableException(String msg) {
        super(msg);
    }
}

// Enum for specialization
enum Specialization {
    CARDIOLOGIST, DERMATOLOGIST, NEUROLOGIST
}

// Appointment class
class Appointment {
    private String patientName;
    private String doctorName;
    private String slot;

    public Appointment(String patientName, String doctorName, String slot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Slot: " + slot;
    }
}

// Doctor class (Encapsulation)
class Doctor {
    private int id;
    private String name;
    private Specialization specialization;
    private List<String> availableSlots;
    private List<Appointment> consultationHistory;

    public Doctor(int id, String name, Specialization specialization, List<String> slots) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>(slots);
        this.consultationHistory = new ArrayList<>();
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public boolean isSlotAvailable(String slot) {
        return availableSlots.contains(slot);
    }

    public void bookSlot(String patientName, String slot) {
        availableSlots.remove(slot);
        consultationHistory.add(new Appointment(patientName, name, slot));
    }

    public List<Appointment> getConsultationHistory() {
        return consultationHistory;
    }

    public String getName() {
        return name;
    }
}

// Scheduler system
public class DoctorScheduler {

    private Map<Specialization, List<Doctor>> doctorMap = new HashMap<>();

    public void addDoctor(Doctor doctor) {
        doctorMap.computeIfAbsent(doctor.getSpecialization(), k -> new ArrayList<>()).add(doctor);
    }

    public void bookAppointment(String patientName, Specialization specialization, String slot)
            throws SlotUnavailableException {

        List<Doctor> doctors = doctorMap.get(specialization);

        if (doctors == null || doctors.isEmpty()) {
            throw new SlotUnavailableException("No doctors available for " + specialization);
        }

        for (Doctor d : doctors) {
            if (d.isSlotAvailable(slot)) {
                d.bookSlot(patientName, slot);
                System.out.println("Appointment booked with Dr. " + d.getName() + " at " + slot);
                return;
            }
        }

        throw new SlotUnavailableException("Slot not available for " + specialization + " at " + slot);
    }

    public void printConsultationHistory() {
        for (List<Doctor> doctors : doctorMap.values()) {
            for (Doctor d : doctors) {
                for (Appointment a : d.getConsultationHistory()) {
                    System.out.println(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        DoctorScheduler scheduler = new DoctorScheduler();

        Doctor d1 = new Doctor(1, "Sharma", Specialization.CARDIOLOGIST,
                Arrays.asList("10AM", "11AM"));
        Doctor d2 = new Doctor(2, "Mehta", Specialization.CARDIOLOGIST,
                Arrays.asList("11AM", "12PM"));
        Doctor d3 = new Doctor(3, "Roy", Specialization.DERMATOLOGIST,
                Arrays.asList("10AM"));

        scheduler.addDoctor(d1);
        scheduler.addDoctor(d2);
        scheduler.addDoctor(d3);

        try {
            scheduler.bookAppointment("Amit", Specialization.CARDIOLOGIST, "10AM");
            scheduler.bookAppointment("Riya", Specialization.CARDIOLOGIST, "10AM"); // different doctor
            scheduler.bookAppointment("Neha", Specialization.DERMATOLOGIST, "10AM");
            scheduler.bookAppointment("Rahul", Specialization.DERMATOLOGIST, "10AM"); // will fail
        } catch (SlotUnavailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nConsultation History:");
        scheduler.printConsultationHistory();
    }
}