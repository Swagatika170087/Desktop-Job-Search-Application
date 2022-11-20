package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class JobApplication {
    private int jobAppId;
    private int jobId;
    private HashMap<Integer, Integer> skills;
    private ArrayList<String> qualifications;
    private LocalDate appliedDate;

    public int getJobAppId() {
        return jobAppId;
    }

    public void setJobAppId(int jobAppId) {
        this.jobAppId = jobAppId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public HashMap<Integer, Integer> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<Integer, Integer> skills) {
        this.skills = skills;
    }

    public ArrayList<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(ArrayList<String> qualifications) {
        this.qualifications = qualifications;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobApplication)) return false;
        JobApplication that = (JobApplication) o;
        return getJobAppId() == that.getJobAppId() && getJobId() == that.getJobId() && Objects.equals(getSkills(), that.getSkills()) && Objects.equals(getQualifications(), that.getQualifications()) && Objects.equals(getAppliedDate(), that.getAppliedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobAppId(), getJobId(), getSkills(), getQualifications(), getAppliedDate());
    }
}
