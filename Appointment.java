public class Appointment {

    private int patientId;
    private String date;
    private String time;
    private String doctorName;
    private String purpose;

    // Used when creating a scheduled appointment
    public Appointment(int patientId, String date, String time, String doctorName, String purpose) {
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.doctorName = doctorName;
        this.purpose = purpose;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPurpose() {
        return purpose;
    }

    // Simple printout for reports or debugging
    @Override
    public String toString() {
        return date + " " + time + " | " + doctorName + " | " + purpose;
    }
}