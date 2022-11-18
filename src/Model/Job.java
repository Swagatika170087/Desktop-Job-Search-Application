package Model;

public class Job {
    private String jobTitle;
    private String jobDesc;
    private String skills;
    private String company;
    private String location;
    private long compensation;
    private String qualification;
    private int experience;

    public Job() {
        // empty constructor
    }

    public Job(String jobTitle, String jobDesc, String skills, String company, String location, long compensation, String qualification, int experience)
    {
        this.jobTitle = jobTitle;
        this.jobDesc = jobDesc;
        this.skills = skills;
        this.company = company;
        this.location = location;
        this.compensation = compensation;
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public String getSkills() {
        return skills;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public long getCompensation() {
        return compensation;
    }

    public String getQualification() {
        return qualification;
    }

    public int getExperience() {
        return experience;
    }

}