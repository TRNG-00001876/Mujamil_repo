package org.example;
import java.sql.*;
public class Main {


    public static void main(String[] args) throws ClassNotFoundException
    {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driverName);

        String url="jdbc:sqlserver://localhost;database=example; integratedSecurity=true;+"+"encrypt=true;trustServerCertificate=true;";

        try(Connection con =DriverManager.getConnection(url))
        {
            Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery("select * from employee");
            while(rs.next())
            {
                System.out.println("name = " + rs.getString("EmpFname"));
                System.out.println("id = " + rs.getInt("Empcode"));
            }
            System.out.println("Connected to database");
        }
        catch(SQLException se)
        {
            System.out.println("Connection faied " +se.getMessage());
        }


    }
}