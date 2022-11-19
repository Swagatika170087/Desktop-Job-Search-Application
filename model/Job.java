public class Job {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private String skillSetRequired;
    private String qualificationRequired;
    private String keywords;
    private int yearsExperienceRequired;
    private int offerSalary;
    private String publishDate;
    private String location;
    private String jobStatus;
    private String jobRemarks;
    private int recruiterId;
    private int catId;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSkillSetRequired() {
        return skillSetRequired;
    }

    public void setSkillSetRequired(String skillSetRequired) {
        this.skillSetRequired = skillSetRequired;
    }

    public String getQualificationRequired() {
        return qualificationRequired;
    }

    public void setQualificationRequired(String qualificationRequired) {
        this.qualificationRequired = qualificationRequired;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getYearsExperienceRequired() {
        return yearsExperienceRequired;
    }

    public void setYearsExperienceRequired(int yearsExperienceRequired) {
        this.yearsExperienceRequired = yearsExperienceRequired;
    }

    public int getOfferSalary() {
        return offerSalary;
    }

    public void setOfferSalary(int offerSalary) {
        this.offerSalary = offerSalary;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobRemarks() {
        return jobRemarks;
    }

    public void setJobRemarks(String jobRemarks) {
        this.jobRemarks = jobRemarks;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
