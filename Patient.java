import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

public class Patient extends Person {

    private int patientId;
    private ArrayList<MedicalRecord> medicalHistory;
    private TreeMap<Date, Appointment> appointments;

    // Creates a patient with empty history and appointment list
    public Patient(int id, String name, String email, String phone) {
        super(name, email, phone);
        this.patientId = id;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new TreeMap<>();
    }

    public int getPatientId() {
        return patientId;
    }

    // Adds a new record to the patient's medical history
    public void addMedicalRecord(MedicalRecord record) {
        medicalHistory.add(record);
    }

    public List<MedicalRecord> getMedicalHistory() {
        return medicalHistory;
    }

    // Stores appointments sorted by date
    public void addAppointment(Appointment appointment) {
        Date dateKey = appointment.getDate();
        appointments.put(dateKey, appointment);
    }

    public Map<Date, Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public String toString() {
        return "Patient " + patientId + " | " + getName();
    }
}