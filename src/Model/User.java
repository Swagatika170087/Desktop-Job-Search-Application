package Model;

import java.util.Objects;

public class User {
    private int userId;
    private String firstname;
    private String lastname;
    private String emailId;
    private String phoneNo;
    private Address address;
    private String username;
    private String password;
    private enum userType {
        ADMIN, RECRUITER, JOBSEEKER
    };

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

    public Address getAddress() { return this.address;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && getFirstname().equals(user.getFirstname()) && getLastname().equals(user.getLastname()) && getEmailId().equals(user.getEmailId()) && getPhoneNo().equals(user.getPhoneNo()) && getAddress().equals(user.getAddress()) && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstname(), getLastname(), getEmailId(), getPhoneNo(), getAddress(), getUsername(), getPassword());
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
