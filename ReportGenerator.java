public interface ReportGenerator {
   // Creates a summary of all stored patient records
    public void generatePatientReport();

    // Creates a summary of all scheduled appointments
    public void generateAppointmentReport();
    
}
