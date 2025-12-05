public class MedicalRecord {

    private String date;
    private String diagnosis;
    private String notes;
    private String doctorName;

    // Creating a single entry in the patient's medical history
    public MedicalRecord(String date, String diagnosis, String notes, String doctorName) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public String getDoctorName() {
        return doctorName;
    }

    // printing the medical history using toString
    @Override
    public String toString() {
        return date + " | " + diagnosis + " | " + doctorName + " | " + notes;
    }
}