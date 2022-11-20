package Model;

import java.util.Objects;

public class Skill {
    private int skillId;
    private String name;
    private int experience;
    private String description;

    public int getSkillId() {
        return skillId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return getSkillId() == skill.getSkillId() && getExperience() == skill.getExperience() && getName().equals(skill.getName()) && getDescription().equals(skill.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getName(), getExperience(), getDescription());
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
