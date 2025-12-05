public class Doctor {

    private String name;
    private String specialty;

    // Basic constructor for creating a doctor entry
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    // Simple description for  listing available doctors when necessary
    @Override
    public String toString() {
        return name + " (" + specialty + ")";
    }
}
