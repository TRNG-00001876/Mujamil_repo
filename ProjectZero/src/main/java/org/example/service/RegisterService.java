package org.example.service;

import org.example.dao.UserRegisterDAO;
import org.example.model.Resume;
import org.example.model.UserRegister;
import org.example.model.EmployeeRegister;

public class RegisterService {
    private UserRegisterDAO userRegisterDAO;



    public RegisterService(UserRegisterDAO userRegisterDAO)
    {
        this.userRegisterDAO=userRegisterDAO;
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

    public void addResume(Resume resume)
    {
        userRegisterDAO.addResume(resume);
    }
}
