import java.time.LocalDateTime;
import java.util.*;

// Hospital management covering patients, doctors, and appointments.
public class HospitalManagementSystem {
    public static void main(String[] args) {
        HospitalService service = new SimpleHospitalService();
        Doctor doc = new Doctor("D1", "Dr. Sen", 500);
        Patient pat = new Patient("P1", "Kabir");

        service.addDoctor(doc);
        service.addPatient(pat);

        Appointment appt = service.bookAppointment("P1", "D1", LocalDateTime.now().plusDays(1));
        System.out.println("Appointment booked with fee: " + appt.calculateFee());
        service.cancelAppointment(appt.getId());
    }
}

abstract class HospitalPerson {
    private final String id;
    private final String name;

    protected HospitalPerson(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Patient extends HospitalPerson {
    private final List<String> medicalHistory = new ArrayList<>();

    Patient(String id, String name) {
        super(id, name);
    }

    public void addHistory(String entry) {
        medicalHistory.add(entry);
    }
}

class Doctor extends HospitalPerson {
    private final double consultationFee;

    Doctor(String id, String name, double consultationFee) {
        super(id, name);
        this.consultationFee = consultationFee;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}

class Appointment {
    enum Status {BOOKED, CANCELLED}

    private final String id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime slot;
    private Status status = Status.BOOKED;

    Appointment(String id, Patient patient, Doctor doctor, LocalDateTime slot) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public double calculateFee() {
        return doctor.getConsultationFee();
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void cancel() {
        status = Status.CANCELLED;
    }
}

interface HospitalService {
    void addPatient(Patient patient);
    void addDoctor(Doctor doctor);
    Appointment bookAppointment(String patientId, String doctorId, LocalDateTime slot);
    void cancelAppointment(String appointmentId);
}

class AppointmentNotAvailableException extends RuntimeException {
    AppointmentNotAvailableException(String msg) {
        super(msg);
    }
}

class SimpleHospitalService implements HospitalService {
    private final Map<String, Patient> patients = new HashMap<>();
    private final Map<String, Doctor> doctors = new HashMap<>();
    private final Map<String, Appointment> appointments = new HashMap<>();

    @Override
    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
    }

    @Override
    public Appointment bookAppointment(String patientId, String doctorId, LocalDateTime slot) {
        if (appointments.values().stream().anyMatch(a -> a.getSlot().equals(slot))) {
            throw new AppointmentNotAvailableException("Slot already taken");
        }
        Patient patient = requirePatient(patientId);
        Doctor doctor = requireDoctor(doctorId);
        Appointment appointment = new Appointment(UUID.randomUUID().toString(), patient, doctor, slot);
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment != null) {
            appointment.cancel();
        }
    }

    private Patient requirePatient(String id) {
        Patient p = patients.get(id);
        if (p == null) {
            throw new IllegalArgumentException("Patient missing " + id);
        }
        return p;
    }

    private Doctor requireDoctor(String id) {
        Doctor d = doctors.get(id);
        if (d == null) {
            throw new IllegalArgumentException("Doctor missing " + id);
        }
        return d;
    }
}

