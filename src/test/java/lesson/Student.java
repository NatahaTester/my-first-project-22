package lesson;
//-------ATTRIBUTES---------
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

//--------CONSTRUCTORS------
    public  Student() {

    }

    public Student(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
//------GETTERS/SETTERS------
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

//---------CUSTOM METODS----------------
    public String getFullName() {
       return firstName + " " + lastName;
    }
}

