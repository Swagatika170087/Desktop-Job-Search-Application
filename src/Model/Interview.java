package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Interview {
    private int jobAppId;
    private int userId;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private enum interviewStatus{
        ACCEPTED, DECLINED, TENTATIVE
    };

    public int getJobAppId() {
        return jobAppId;
    }

    public void setJobAppId(int jobAppId) {
        this.jobAppId = jobAppId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interview)) return false;
        Interview interview = (Interview) o;
        return getJobAppId() == interview.getJobAppId() && getUserId() == interview.getUserId() && Objects.equals(getInterviewDate(), interview.getInterviewDate()) && Objects.equals(getInterviewTime(), interview.getInterviewTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobAppId(), getUserId(), getInterviewDate(), getInterviewTime());
    }
}
