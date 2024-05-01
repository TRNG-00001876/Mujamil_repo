package org.example.dao;

import org.example.model.EmployeeRegister;
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

    void validateEmployee(String gmail,String paaword);

    void addResume(Resume resume);
}
