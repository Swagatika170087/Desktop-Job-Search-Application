package Model;

public class JobSeeker extends User{
    private int jobSeekerId;
    private String qualification;
    public JobSeeker(String username, String password) {
        super(username, password);
    }
    public JobSeeker(String firstname, String lastname, String emailId, String phoneNo, String city, String state, String country, String qualification, String username, String password) {
        super(firstname, lastname, emailId, phoneNo, city, state, country, username, password);
        this.qualification = qualification;
    }
    // getters

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public String getQualification() {
        return qualification;
    }
}