package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Job {
    private int jobId;
    private int userId;
    private int categoryId;
    private String jobTitle;
    private String jobDesc;
    private ArrayList<String> skills;
    private String company;
    private Address address;
    private Long compensation;
    private String qualification;
    private Integer experience;
    private LocalDate postedOn;
    public int getJobId() {
        return jobId;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public String getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }

    public Long getCompensation() {
        return compensation;
    }

    public String getQualification() {
        return qualification;
    }

    public Integer getExperience() {
        return experience;
    }

    public LocalDate getPostedOn() {
        return postedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getJobId() == job.getJobId() && getUserId() == job.getUserId() && getCategoryId() == job.getCategoryId() && getCompensation() == job.getCompensation() && getExperience() == job.getExperience() && getJobTitle().equals(job.getJobTitle()) && getJobDesc().equals(job.getJobDesc()) && getSkills().equals(job.getSkills()) && getCompany().equals(job.getCompany()) && getAddress().equals(job.getAddress()) && getQualification().equals(job.getQualification()) && getPostedOn().equals(job.getPostedOn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobId(), getUserId(), getCategoryId(), getJobTitle(), getJobDesc(), getSkills(), getCompany(), getAddress(), getCompensation(), getQualification(), getExperience(), getPostedOn());
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCompensation(Long compensation) {
        this.compensation = compensation;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setPostedOn(LocalDate postedOn) {
        this.postedOn = postedOn;
    }
}