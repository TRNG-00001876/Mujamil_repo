package org.example.service;

import org.example.dao.UserRegisterDAO;
import org.example.model.Resume;
import org.example.model.UserRegister;
import org.example.model.EmployeeRegister;

import java.util.List;

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

    public void validateEmployee(String gmail,String paaword)
    {
        userRegisterDAO.validateEmployee(gmail, paaword);
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

}
