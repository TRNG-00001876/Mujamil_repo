package org.example.service;

import org.example.dao.UserRegisterDAO;
import org.example.model.Job;
import org.example.model.Resume;
import org.example.model.UserRegister;
import org.example.model.EmployeeRegister;

public class RegisterService {
    private UserRegisterDAO userRegisterDAO;



    public RegisterService(UserRegisterDAO userRegisterDAO)
    {
        this.userRegisterDAO=userRegisterDAO;
    }

    public boolean validString(String name)
    {
        return userRegisterDAO.validString(name);
    }

    public boolean validMail(String mail)
    {
        return userRegisterDAO.validMail(mail);
    }

    public boolean validPassword(String password)
    {
        return userRegisterDAO.validPassword(password);
    }

    public void addUserDetails(UserRegister user_reg)
    {
        userRegisterDAO.addUserDetails(user_reg);
    }

    public boolean validateUser(String gmail,String password)
    {
         return userRegisterDAO.validateUser(gmail,password);
    }

    public void addEmpDetails(EmployeeRegister employeeRegister)
    {
        userRegisterDAO.addEmpDetails(employeeRegister);
    }

    public boolean validateEmployee(String gmail,String paaword)
    {
        return userRegisterDAO.validateEmployee(gmail, paaword);
    }

    public void addResume(Resume resume,String gmail)
    {
        userRegisterDAO.addResume(resume,gmail);
    }

    public void viewResume(String user_name)
    {
       userRegisterDAO.viewResume(user_name);
    }

    public void updateResume(String location,String skillset1,String skillset2,String skillset3,String user_name)
    {
        userRegisterDAO.updateResume(location,skillset1,skillset2,skillset3,user_name);
    }

    public void deleteResume(String user_name)
    {
        userRegisterDAO.deleteResume(user_name);
    }

    public void postJob(Job job, String name)
    {
        userRegisterDAO.postJob(job,name);
    }

    public void viewApplication(String mail)
    {
        userRegisterDAO.viewApplication(mail);
    }

    public boolean checkupdateApplication(String role)
    {
        return userRegisterDAO.checkupdateApplication(role);
    }

    public void updateApplication(String gmail,String role,String required,String experience,String lpa)
    {
        userRegisterDAO.updateApplication(gmail,role,required,experience,lpa);
    }

    public void deleteApplication(String gmail)
    {
        userRegisterDAO.deleteApplication(gmail);
    }

    public void listAllJobs()
    {
        userRegisterDAO.listAllJobs();
    }

    public void searchByRole(String role)
    {
        userRegisterDAO.searchByRole(role);
    }

    public void searchByRequired(String req)
    {
        userRegisterDAO.searchByRequired(req);
    }

    public boolean checkValidForApply(String gmail,String crole)
    {
        return userRegisterDAO.checkValidForApply(gmail,crole);
    }

    public void applyForJob(String mail,String name)
    {
        userRegisterDAO.applyForJob(mail,name);
    }

    public void status(String gmail){
        userRegisterDAO.status(gmail);
    }

    public void userlist(String gmail){
        userRegisterDAO.userlist(gmail);
    }

    public void accpetOrReject(String status,String mail)
    {
        userRegisterDAO.accpetOrReject(status,mail);
    }

}
