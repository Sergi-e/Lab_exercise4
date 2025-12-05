public class Person {
 private String name;
    private String email;
    private String phone;

    // Basic constructor for creating a person record
    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //setters and getters for updating when necessary
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // printing out basic person details
    @Override
    public String toString() {
        return name + " | " + email + " | " + phone;
    }
}