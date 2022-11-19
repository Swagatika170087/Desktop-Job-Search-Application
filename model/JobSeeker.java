public class JobSeeker {
    private int jobSeekerId;
    private String aboutYourself;
    private String searchedJobs;
    private int userId;

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String aboutYourself) {
        this.aboutYourself = aboutYourself;
    }

    public String getSearchedJobs() {
        return searchedJobs;
    }

    public void setSearchedJobs(String searchedJobs) {
        this.searchedJobs = searchedJobs;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
