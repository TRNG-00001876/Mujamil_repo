package org.example.dao;
import org.example.model.EmployeeRegister;
import org.example.model.UserRegister;
import org.example.model.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public boolean validString(String name)
    {
        if(name==null || name.isEmpty())
        {
            return  false;
        }
        for(char c:name.toCharArray())
        {
            if(! Character.isLetter(c) || c==' ' || c=='/' || c==',' || c=='-')
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validMail(String mail)
    {
        String pattern="^[a-zA-Z0-9._%+-]+@gmail.com$";
        return mail.matches(pattern);
    }

    public boolean validPassword(String password)
    {
        String pattern=".*[!@#$%^&*()\\\\-_=+\\\\\\\\|\\\\[{\\\\]};:'\\\",<.>/?].*";
        return password.matches(pattern);
    }

    @Override
    public void addUserDetails(UserRegister user_reg)
    {
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO USERDATA(name,gmail,password) VALUES (?,?,?)");
            preparedStatement.setString(1,user_reg.getName());
            preparedStatement.setString(2,user_reg.getGmail());
            preparedStatement.setString(3,user_reg.getPassword());
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
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from USERDATA WHERE gmail=? AND password=? ");
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
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPDATA(company_name,gmail,password) VALUES (?,?,?)");
            preparedStatement.setString(1,employeeRegister.getCompanyName());
            preparedStatement.setString(2,employeeRegister.getGmail());
            preparedStatement.setString(3,employeeRegister.getPassword());
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
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from EMPDATA WHERE gmail=? AND password=? ");
            preparedStatement.setString(1,gmail);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String Cgmail=resultSet.getString("gmail");
                String Cpassword=resultSet.getString("password");
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
    public void addResume(Resume resume,String gmail)
    {
        try{
            int id=0;
            int cid=0;
            PreparedStatement preparedStatement=connection.prepareStatement("select * from userdata where gmail=?");
            preparedStatement.setString(1,gmail);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
            {
                id=resultSet.getInt("id");
            }
            PreparedStatement preparedStatement2=connection.prepareStatement("select id from empresume where id=?");
            preparedStatement2.setInt(1,id);
            ResultSet resultSet1=preparedStatement2.executeQuery();
            if(resultSet1.next())
            {
                cid=resultSet1.getInt("id");
            }
            if(cid==id)
            {
                System.err.println("Already Resume has been Created ");
            }
            else{
                PreparedStatement preparedStatement1=connection.prepareStatement("INSERT INTO EMPRESUME(id,location,skillset1,skillset2,skillset3) VALUES (?,?,?,?,?)");
                preparedStatement1.setInt(1,id);
                preparedStatement1.setString(2,resume.getLocation());
                preparedStatement1.setString(3,resume.getSkillset1());
                preparedStatement1.setString(4,resume.getSkillset2());
                preparedStatement1.setString(5,resume.getSkillset3());
                preparedStatement1.executeUpdate();
                System.out.println("Sucessfully resume created");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void viewResume(String user_name)
    {
        try {
            int id=0;
            String name="";
            PreparedStatement preparedStatement1=connection.prepareStatement("select * from userdata where gmail=?");
            preparedStatement1.setString(1,user_name);
            ResultSet resultSet1=preparedStatement1.executeQuery();
            if(resultSet1.next())
            {
               id=resultSet1.getInt("id");
               name=resultSet1.getString("name");
            }

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM empresume where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("***********************");
            System.out.println("Resume");
            System.out.println("Name: "+name);
            System.out.println("gmail: "+user_name);
            if(resultSet.next()) {
                System.out.println("id : "+resultSet.getInt("id"));
                System.out.println("location : "+resultSet.getString("location"));
                System.out.println("skillset1 : "+resultSet.getString("skillset1"));
                System.out.println("skillset2 : "+resultSet.getString("skillset2"));
                System.out.println("skillset3 : "+resultSet.getString("skillset3"));
                System.out.println("***********************");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateResume(String location,String skillset1,String skillset2,String skillset3,String user_name)
    {
        try{
            int id=0;
            PreparedStatement preparedStatement1=connection.prepareStatement("select * from userdata where gmail=?");
            preparedStatement1.setString(1,user_name);
            ResultSet resultSet1=preparedStatement1.executeQuery();
            if(resultSet1.next())
            {
                id=resultSet1.getInt("id");
            }
            PreparedStatement preparedStatement = connection.prepareStatement("update empresume set location=? , skillset1=?, skillset2=?, skillset3=? where id=?");

            preparedStatement.setInt(4,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteResume(String user_name)
    {
        try{
            int id=0;
            PreparedStatement preparedStatement1=connection.prepareStatement("select * from userdata where gmail=?");
            preparedStatement1.setString(1,user_name);
            ResultSet resultSet1=preparedStatement1.executeQuery();
            if(resultSet1.next())
            {
                id=resultSet1.getInt("id");
            }
            PreparedStatement preparedStatement = connection.prepareStatement("delete FROM empresume where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
            System.out.println("Sucessfully Deleted");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
