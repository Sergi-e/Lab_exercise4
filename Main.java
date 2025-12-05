import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClinicManagementSystem cms = new ClinicManagementSystem();
        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Nantembea Health Clinic System");
            System.out.println("1. Add Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. List All Patients");
            System.out.println("4. Load Patients From File");
            System.out.println("5. Save Patients To File");
            System.out.println("6. Load Appointments From File");
            System.out.println("7. Save Appointments To File");
            System.out.println("8. Generate Patient Report");
            System.out.println("9. Generate Appointment Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Phone: ");
                    String phone = input.nextLine();

                    cms.addPatient(name, email, phone);
                    System.out.println("Patient added.");
                    break;

                case "2":
                    System.out.print("Patient ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = input.nextLine();

                    System.out.print("Time (HH:MM): ");
                    String time = input.nextLine();

                    System.out.print("Doctor: ");
                    String doctor = input.nextLine();

                    System.out.print("Purpose: ");
                    String purpose = input.nextLine();

                    cms.addAppointment(id, date, time, doctor, purpose);
                    System.out.println("Appointment scheduled.");
                    break;

                case "3":
                    System.out.println("Registered Patients:");
                    for (Patient p : cms.listAllPatients()) {
                        System.out.println(p.getPatientId() + " - " + p.getName());
                    }
                    break;

                case "4":
                    System.out.print("Enter patient file name: ");
                    String loadFile = input.nextLine();
                    cms.loadFromFile(loadFile);
                    System.out.println("Patients loaded.");
                    break;

                case "5":
                    System.out.print("Enter file name to save: ");
                    String saveFile = input.nextLine();
                    cms.saveToFile(saveFile);
                    System.out.println("Patients saved.");
                    break;

                case "6":
                    System.out.print("Enter appointment file name: ");
                    String appLoadFile = input.nextLine();
                    cms.loadAppointmentsFromFile(appLoadFile);
                    System.out.println("Appointments loaded.");
                    break;

                case "7":
                    System.out.print("Enter file name to save appointments: ");
                    String appSaveFile = input.nextLine();
                    cms.saveAppointmentsToFile(appSaveFile);
                    System.out.println("Appointments saved.");
                    break;

                case "8":
                    cms.generatePatientReport();
                    break;

                case "9":
                    cms.generateAppointmentReport();
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
