package Model;

public class Recruiter extends User{
    private String recruiterId;
    private String company;
    public Recruiter(String username, String password) {
        super(username, password);
    }
    public Recruiter(String firstname, String lastname, String emailId, String phoneNo, String company, String city, String state, String country, String username, String password) {
        super(firstname, lastname, emailId, phoneNo, city, state, country, username, password);
        this.company = company;
    }
    // getters
    public String getRecruiterId() {
        return recruiterId;
    }

    public String getCompany() {
        return company;
    }
}