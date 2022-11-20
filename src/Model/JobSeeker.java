package Model;

import java.util.ArrayList;
import java.util.Objects;

public class JobSeeker extends User{
    private int userId;
    private ArrayList<String> skills;
    private ArrayList<String> qualifications;

    // getters
    public ArrayList<String> getQualifications() {
        return qualifications;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSeeker)) return false;
        if (!super.equals(o)) return false;
        JobSeeker jobSeeker = (JobSeeker) o;
        return getUserId() == jobSeeker.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserId());
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void setQualifications(ArrayList<String> qualifications) {
        this.qualifications = qualifications;
    }
}