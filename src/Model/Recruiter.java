package Model;

import java.util.Objects;

public class Recruiter extends User{
    private int userId;
    private String company;
    // getters
    public String getCompany() {
        return company;
    }
    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recruiter)) return false;
        if (!super.equals(o)) return false;
        Recruiter recruiter = (Recruiter) o;
        return getUserId() == recruiter.getUserId() && Objects.equals(getCompany(), recruiter.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserId(), getCompany());
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}