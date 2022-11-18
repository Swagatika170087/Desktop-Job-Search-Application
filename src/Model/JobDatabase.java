package Model;

import java.io.*;
import java.util.ArrayList;

public class JobDatabase {
    private ArrayList<Job> jobArrayList;

    public JobDatabase() {
        jobArrayList = new ArrayList<>();
    }

    // adds jobs to our collection
    public void addJob(Job job) {
        jobArrayList.add(job);
    }

    // saves jobs to database file
    public void saveJob(File file) {
        try {
            // job seeker model
            Job job;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < jobArrayList.size()) {
                job = jobArrayList.get(i);
                save_data = job.getJobTitle() +
                            ", " + job.getJobDesc() +
                            ", " + job.getSkills() +
                            ", " + job.getCompany() +
                            ", " + job.getLocation() +
                            ", " + job.getCompensation() +
                            ", " + job.getQualification() +
                            ", " + job.getExperience();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // reads job seeker from database file
    public Object[] loadJobs(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
