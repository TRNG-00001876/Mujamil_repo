package org.example.dao;

import org.example.model.EmployeeRegister;
import org.example.model.Job;
import org.example.model.UserRegister;
import org.example.model.Resume;

import java.util.List;

public interface UserRegisterDAO
{
    boolean validString(String name);

    boolean validMail(String mail);

    boolean validPassword(String password);

    void addUserDetails(UserRegister user_reg);

    boolean validateUser(String gmail,String password);

    void addEmpDetails(EmployeeRegister employeeRegister);

    boolean validateEmployee(String gmail,String password);

    void addResume(Resume resume,String name);

    void viewResume(String user_name);

    void updateResume(String location,String skillset1,String skillset2,String skillset3,String user_name);

    void deleteResume(String user_name);

    void postJob(Job job,String name);

    void viewApplication(String mail);

    boolean checkupdateApplication(String role);

    void updateApplication(String gmail,String role,String required,String experience,String lpa);

    void deleteApplication(String gmail);

    void listAllJobs();

    void searchByRole(String role);

    void searchByRequired(String req);

    boolean checkValidForApply(String gmail,String role);

    void applyForJob(String mail,String name);

    void status(String gmail);

    void userlist(String gmail);

    void accpetOrReject(String status,String mail);

}
