package Model;

public class User {
    private int userId;
    private String firstname;
    private String lastname;
    private String emailId;
    private String phoneNo;
    private String city;
    private String state;
    private String country;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String firstname, String lastname, String emailId, String phoneNo, String city, String state, String country, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

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

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
