package Model;

import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<JobSeeker> jobSeekerArrayList;

    public Database() {
        jobSeekerArrayList = new ArrayList<>();
    }

    // adds job seeker to our collection
    public void addJobSeeker(JobSeeker jobSeeker) {
        jobSeekerArrayList.add(jobSeeker);
    }

    // saves job seeker to database file
    public void saveJobSeeker(File file) {
        try {
            // job seeker model
            JobSeeker jobSeeker;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < jobSeekerArrayList.size()) {
                jobSeeker = jobSeekerArrayList.get(i);
                save_data = jobSeeker.getFirstname() +
                            ", " + jobSeeker.getLastname() +
                            ", " + jobSeeker.getEmailId() +
                            ", " + jobSeeker.getPhoneNo() +
                            ", " + jobSeeker.getAddress() +
                            ", " + jobSeeker.getUsername() +
                            ", " + jobSeeker.getPassword();
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
    public Object[] loadJobSeekers(File file) {
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