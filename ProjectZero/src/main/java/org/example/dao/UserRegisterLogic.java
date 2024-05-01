package org.example.dao;
import org.example.model.EmployeeRegister;
import org.example.model.UserRegister;
import org.example.model.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserRegisterLogic implements UserRegisterDAO
{
    private static UserRegisterLogic instance;
    private Connection connection;

    private UserRegisterLogic(Connection connection)
    {
        this.connection=connection;
    }

    public static synchronized UserRegisterLogic getInstance(Connection connection)
    {
        if(instance==null)
        {
            instance=new UserRegisterLogic(connection);
        }
        return instance;
    }

    @Override
    public void addUserDetails(UserRegister user_reg)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO USER_DATA(id,name,gmail,password) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,user_reg.getId());
            preparedStatement.setString(2,user_reg.getName());
            preparedStatement.setString(3,user_reg.getGmail());
            preparedStatement.setString(4,user_reg.getPassword());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateUser(String gmail,String password)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from USER_DATA WHERE gmail=? AND password=? ");
            preparedStatement.setString(1,gmail);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String Cgmail=resultSet.getString("gmail");
                String Cpassword=resultSet.getString("password");
                if(gmail==Cgmail &&password==Cpassword)
                {
                    return true ;
                }
                return true;
            }
            else{
                System.out.println("No record is there just register and login ");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addEmpDetails(EmployeeRegister employeeRegister)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMP_DATA(id,company_name,gmail,password) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,employeeRegister.getId());
            preparedStatement.setString(2,employeeRegister.getCompanyName());
            preparedStatement.setString(3,employeeRegister.getGmail());
            preparedStatement.setString(4,employeeRegister.getPassword());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void validateEmployee(String gmail,String password)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from EMP_DATA WHERE gmail=? AND password=? ");
            preparedStatement.setString(1,gmail);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String Cgmail=resultSet.getString("gmail");
                String Cpassword=resultSet.getString("password");
                System.out.println(gmail);
                System.out.println(password);
                System.out.println("**********");
                System.out.println(Cgmail);
                System.out.println(Cpassword);
                if(gmail.equals(Cgmail) && password.equals(Cpassword))
                {
                    System.out.println("login Sucessfully");
                }
            }
            else{
                System.out.println("No record is there just register and login ");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addResume(Resume resume)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMP_RESUME(id,location,skillset1,skillset2,skillset3) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,resume.getId());
            preparedStatement.setString(2,resume.getLocation());
            preparedStatement.setString(3,resume.getSkillset1());
            preparedStatement.setString(4,resume.getSkillset2());
            preparedStatement.setString(5,resume.getSkillset3());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
