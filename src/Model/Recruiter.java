package Model;

public class Recruiter {
    private String firstname;
    private String lastname;
    private String emailId;
    private String phoneNo;
    private String company;
    private String address;
    private String username;
    private String password;

    public Recruiter() {
        // empty constructor
    }

    public Recruiter(String firstname, String lastname, String emailId, String phoneNo, String company, String address, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.address = address;
        this.username = username;
        this.password = password;
        this.company = company;
    }

    // getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}