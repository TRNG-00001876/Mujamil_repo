package org.example;
import org.example.model.EmployeeRegister;
import org.example.model.Resume;
import org.example.model.UserRegister;
import org.example.dao.UserRegisterDAO;
import org.example.dao.UserRegisterLogic;
import org.example.service.RegisterService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    static
    {
        System.out.println("Welcome To RevHire '.' ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=projectzero;integratedSecurity=True;encrypt=True;TrustServerCertificate=True");
            UserRegisterDAO userRegisterDAO = UserRegisterLogic.getInstance(connection);
            RegisterService registerService = new RegisterService(userRegisterDAO);
            Scanner scanner = new Scanner(System.in);
            boolean exit = true;
            while (exit)
            {
                System.out.println("******************");
                System.out.println("1) job seaker ");
                System.out.println("2) Employee ");
                System.out.println("3) Exit ");
                System.out.println("******************");
                int choice_outer = scanner.nextInt();
                switch (choice_outer)
                {
                    case 1: boolean exitOne=true;
                            while(exitOne)
                            {
                                System.out.println("Choose operation");
                                System.out.println("1)User Register");
                                System.out.println("2)User Login");
                                System.out.println("3)Go Back ");
                                int choiceOne = scanner.nextInt();
                                switch (choiceOne)
                                {
                                    case 1: System.out.println("Enter ID");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter your NAME");
                                            String name = scanner.nextLine();
                                            System.out.println("Enter Mail ID");
                                            String gmail = scanner.nextLine();
                                            System.out.println("Enter PASSWORD");
                                            String password = scanner.nextLine();
                                            UserRegister userRegister = new UserRegister(id, name, gmail, password);
                                            registerService.addUserDetails(userRegister);
                                            break;

                                    case 2: System.out.println("Enter user gmail");
                                            scanner.nextLine();
                                            String user_name = scanner.nextLine();
                                            System.out.println("Enter password");
                                            String user_password = scanner.nextLine();
                                            if(registerService.validateUser(user_name, user_password))
                                            {
                                                System.out.println("Sucessfully Login");
                                                boolean exitoneone=true;
                                                while(exitoneone)
                                                {
                                                    System.out.println("1) Create Resume");
                                                    System.out.println("2) Update Resume");
                                                    System.out.println("3) Delete Resume");
                                                    System.out.println("4) View Resume");
                                                    System.out.println("5) Search job");
                                                    System.out.println("6) Exit");
                                                    int choiceoneone= scanner.nextInt();
                                                    switch (choiceoneone)
                                                    {
                                                        case 1: System.out.println("Enter the id");
                                                            int resumeid= scanner.nextInt();
                                                            scanner.nextLine();
                                                            System.out.println("Enter your location");
                                                            String location=scanner.nextLine();
                                                            System.out.println("Enter your Skillset 1");
                                                            String skillset1=scanner.nextLine();
                                                            System.out.println("Enter your Skillset 2");
                                                            String skillset2=scanner.nextLine();
                                                            System.out.println("Enter your Skillset 3");
                                                            String skillset3=scanner.nextLine();
                                                            Resume resume=new Resume(resumeid,location,skillset1,skillset2,skillset3);
                                                            registerService.addResume(resume);
                                                    }
                                                }
                                            }
                                            break;

                                    case 3: exitOne=false;
                                            break;

                                    default: System.out.println("Invalid choice");
                                }
                            }
                            break;

                    case 2:boolean exitTwo=true;
                            while(exitTwo)
                            {
                                System.out.println("Choose operation");
                                System.out.println("1)Employee Register");
                                System.out.println("2)Employee Login");
                                System.out.println("3)Go Back ");
                                int choiceTwo = scanner.nextInt();
                                switch (choiceTwo)
                                {
                                    case 1: System.out.println("Enter ID");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter your Company NAME");
                                            String companyname = scanner.nextLine();
                                            System.out.println("Enter Mail ID");
                                            String gmail = scanner.nextLine();
                                            System.out.println("Enter PASSWORD");
                                            String password = scanner.nextLine();
                                            EmployeeRegister employeeRegister = new EmployeeRegister(id,companyname,gmail,password);
                                            registerService.addEmpDetails(employeeRegister);
                                            break;

                                    case 2: System.out.println("Enter Employee gmail");
                                            scanner.nextLine();
                                            String user_gmail = scanner.nextLine();
                                            System.out.println("Enter password");
                                            String user_password = scanner.nextLine();
                                            registerService.validateEmployee(user_gmail, user_password);
                                            break;

                                    case 3: exitTwo=false;
                                            break;

                                    default: System.out.println("Invalid choice");
                                }
                            }
                            break;

                    case 3:exit=false;
                           break;
                }
            }
        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Thanks For Using See You Again '.'");
}








//    public static void adduser(Scanner scanner)
//    {
//        System.out.println("Enter ID");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter your NAME");
//        String name = scanner.nextLine();
//        System.out.println("Enter Mail ID");
//        String gmail = scanner.nextLine();
//        System.out.println("Enter PASSWORD");
//        String password = scanner.nextLine();
//        UserRegister userRegister = new UserRegister(id, name, gmail, password);
//        registerService.addUserDetails(userRegister);
//    }

//    public static void validateUser(Scanner scanner)
//    {
//        System.out.println("Enter user Name");
//        String user_name = scanner.nextLine();
//        System.out.println("Enter password");
//        String user_password = scanner.nextLine();
//        registerService.validateUser(user_name,user_password);
//    }
}