package Model;

import java.io.*;
import java.util.ArrayList;

public class RecruiterDatabase {

    private ArrayList<Recruiter> recruiterArrayList;

    public RecruiterDatabase() {
        recruiterArrayList = new ArrayList<>();
    }

    // adds Recruiter to our collection
    public void addRecruiter(Recruiter recruiter) {
        recruiterArrayList.add(recruiter);
    }

    // saves Recruiter to database file
    public void saveRecruiter(File file) {
        try {
            // Recruiter model
            Recruiter recruiter;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < recruiterArrayList.size()) {
                recruiter = recruiterArrayList.get(i);
                save_data = recruiter.getFirstname() +
                            ", " + recruiter.getLastname() +
                            ", " + recruiter.getEmailId() +
                            ", " + recruiter.getPhoneNo() +
                            ", " + recruiter.getCompany() +
                            ", " + recruiter.getAddress() +
                            ", " + recruiter.getUsername() +
                            ", " + recruiter.getPassword();
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

    // reads Recruiter from database file
    public Object[] loadRecruiters(File file) {
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