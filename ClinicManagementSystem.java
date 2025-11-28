import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

public class ClinicManagementSystem implements FileOperations, ReportGenerator{
    private HashMap<Integer, Patient> patients;
    private ArrayList<Doctor> doctors;
    private TreeMap<String, ArrayList<Appointment>> appointmentByDate;
    private static int nextPatientId=1;
    //constructor
    public ClinicManagementSystem(){
    this.patients=new HashMap<>();
    this.doctors=new ArrayList<>();
    this.appointmentByDate=new TreeMap<>();
}
//implementing interface methods
@Override
public void saveToFile(String filename) throws IOException {
    //use fileWriter to save Patient data
}

@Override
public void loadFromFile(String filename){
    //using scanner to read the patient data
    try(Scanner scanner=new Scanner(new File(filename))){
        while(scanner.HasNextLine()){
            String line=scanner.nextLine();
            parse and create patient objects
        }
    }
}
public void addPatient(String name, String email, String phone){
    Patient patient=new Patient(nextPatientId++, name, email, phone);
    patients.put(patient.patientId(), patient);
}

//find patient implementation
public void findPatient()

}

