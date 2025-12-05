import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;

public class ClinicManagementSystem implements FileOperations, ReportGenerator {

    private HashMap<Integer, Patient> patients;
    private ArrayList<Doctor> doctors;
    private TreeMap<String, ArrayList<Appointment>> appointmentsByDate;
    private static int nextPatientId = 1001;

    public ClinicManagementSystem() {
        patients = new HashMap<>();
        doctors = new ArrayList<>();
        appointmentsByDate = new TreeMap<>();
    }

    // Registers a new patient and stores them
    public void addPatient(String name, String email, String phone) {
        Patient p = new Patient(nextPatientId, name, email, phone);
        patients.put(nextPatientId, p);
        nextPatientId++;
    }

    public Patient findPatient(int patientId) {
        return patients.get(patientId);
    }

    // Adds an appointment and sorts it by date
    public void addAppointment(int patientId, String date, String time, String doctor, String purpose) {

        Patient p = patients.get(patientId);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }

        Appointment ap = new Appointment(patientId, date, time, doctor, purpose);
        p.addAppointment(ap);

        // Store appointment under its date
        appointmentsByDate.putIfAbsent(date, new ArrayList<>());
        appointmentsByDate.get(date).add(ap);
    }

    public List<Appointment> getAppointmentsByDate(String date) {
        return appointmentsByDate.getOrDefault(date, new ArrayList<>());
    }

    public List<Patient> listAllPatients() {
        return new ArrayList<>(patients.values());
    }

    // Saves patient data to file
    @Override
    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            for (Patient p : patients.values()) {
                String line = p.getPatientId() + "," 
                            + p.getName() + "," 
                            + p.getEmail() + "," 
                            + p.getPhone();
                writer.write(line + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save patient data.");
        }
    }

    // Loads patient data from file
    @Override
    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                String phone = parts[3];

                Patient p = new Patient(id, name, email, phone);
                patients.put(id, p);

                // Keep track of the highest ID
                if (id >= nextPatientId) {
                    nextPatientId = id + 1;
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Could not load patient data.");
        }
    }

    // Saves all appointments to file
    public void saveAppointmentsToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            for (String date : appointmentsByDate.keySet()) {
                for (Appointment ap : appointmentsByDate.get(date)) {
                    String line = ap.getPatientId() + "," 
                                + ap.getDate() + "," 
                                + ap.getTime() + "," 
                                + ap.getDoctorName() + "," 
                                + ap.getPurpose();
                    writer.write(line + "\n");
                }
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save appointments.");
        }
    }

    // Loads appointments from file
    public void loadAppointmentsFromFile(String filename) {
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                int patientId = Integer.parseInt(parts[0]);
                String date = parts[1];
                String time = parts[2];
                String doctor = parts[3];
                String purpose = parts[4];

                Appointment ap = new Appointment(patientId, date, time, doctor, purpose);

                Patient p = patients.get(patientId);
                if (p != null) {
                    p.addAppointment(ap);
                }

                appointmentsByDate.putIfAbsent(date, new ArrayList<>());
                appointmentsByDate.get(date).add(ap);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Could not load appointments.");
        }
    }

    // Prints all patients in a readable format
    @Override
    public void generatePatientReport() {
        System.out.println("Patient Report");
        System.out.println("----------------");

        for (Patient p : patients.values()) {
            System.out.println(p.getPatientId() + " - " + p.getName());
        }
    }

    // Prints appointments grouped by date
    @Override
    public void generateAppointmentReport() {
        System.out.println("Appointment Report");
        System.out.println("------------------");

        for (String date : appointmentsByDate.keySet()) {
            System.out.println("Date: " + date);

            for (Appointment ap : appointmentsByDate.get(date)) {
                System.out.println("  " + ap);
            }
        }
    }

    @Override
    public String toString() {
        return "ClinicManagementSystem with " + patients.size() + " patients.";
    }
}
