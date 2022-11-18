package Model;

public class Skill {
    private int skillId;
    private int jobSeekerId;
    private String name;
    private int experience;
    private String description;

    public Skill(int jobSeekerId, String name, int experience, String description) {
        this.jobSeekerId = jobSeekerId;
        this.name = name;
        this.experience = experience;
        this.description = description;
    }

    public int getSkillId() {
        return skillId;
    }

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getDescription() {
        return description;
    }
}
