public class Patient  extends Person{
    private String patientId;
    private ArrayList<MedicalRecord> medicalHistory;
    private TreeMap<Date, Appointment> appointments;
}
//Constructors, getters and setters