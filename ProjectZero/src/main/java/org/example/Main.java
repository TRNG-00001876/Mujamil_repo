package org.example;
import org.example.model.EmployeeRegister;
import org.example.model.Job;
import org.example.model.Resume;
import org.example.model.UserRegister;
import org.example.dao.UserRegisterDAO;
import org.example.dao.UserRegisterLogic;
import org.example.service.RegisterService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main
{
    private static final Logger log=LoggerFactory.getLogger(Main.class);
    static
    {
        System.out.println("Welcome To RevHire '.' ");
    }

    public static void main(String[] args)
    {
        log.info("Application start");
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
                System.out.println("1) job Seaker ");
                System.out.println("2) Employee ");
                System.out.println("3) Exit ");
                System.out.println("******************");
                int choice_outer = scanner.nextInt();
                switch (choice_outer)
                {
                    case 1: boolean exitOne=true;
                            while(exitOne)
                            {
                                System.out.println("***********************");
                                System.out.println("Choose operation");
                                System.out.println("1)User Register");
                                System.out.println("2)User Login");
                                System.out.println("3)Go Back ");
                                System.out.println("***********************");
                                int choiceOne = scanner.nextInt();
                                switch (choiceOne)
                                {
                                    case 1: boolean flag=true;
                                            String name="";
                                            while(flag)
                                            {
                                                scanner.nextLine();
                                                System.out.println("Enter your name");
                                                name=scanner.nextLine();
                                                if(registerService.validString(name))
                                                {
                                                    flag=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid name");
                                                }
                                            }

                                            boolean flag1=true;
                                            String gmail="";
                                            while(flag1)
                                            {
                                                System.out.println("Enter your mail");
                                                gmail=scanner.nextLine();
                                                if(registerService.validMail(gmail))
                                                {
                                                    flag1=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid gmail");
                                                }
                                            }

                                            boolean flag2=true;
                                            String password="";
                                            while(flag2)
                                            {
                                                System.out.println("Enter your Password");
                                                password=scanner.nextLine();
                                                if(registerService.validPassword(password))
                                                {
                                                    flag2=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid password");
                                                }
                                            }

                                            UserRegister userRegister = new UserRegister(name, gmail, password);
                                            System.out.println("Register sucessfully");
                                            registerService.addUserDetails(userRegister);
                                            log.info("job seaker registered");
                                            break;

                                    case 2: System.out.println("Enter user gmail");
                                            scanner.nextLine();
                                            String user_name = scanner.nextLine();
                                            System.out.println("Enter password");
                                            String user_password = scanner.nextLine();
                                            if(registerService.validateUser(user_name, user_password))
                                            {
                                                System.out.println("Sucessfully Login");
                                                log.info("Sucessfully Login");
                                                boolean exitoneone=true;
                                                while(exitoneone)
                                                {
                                                    System.out.println("***********************");
                                                    System.out.println("1) Resume");
                                                    System.out.println("2) Search job");
                                                    System.out.println("3) Exit");
                                                    System.out.println("***********************");
                                                    int choiceoneone= scanner.nextInt();
                                                    switch (choiceoneone)
                                                    {
                                                        case 1: boolean flag3=true;
                                                                while(flag3)
                                                                {
                                                                    System.out.println("***********************");
                                                                    System.out.println("1) Create Resume");
                                                                    System.out.println("2) View Resume");
                                                                    System.out.println("3) Update Resume");
                                                                    System.out.println("4) Delete Resume");
                                                                    System.out.println("5) Go back");
                                                                    System.out.println("***********************");
                                                                    int flag3ch=scanner.nextInt();
                                                                    scanner.nextLine();
                                                                    switch (flag3ch)
                                                                    {
                                                                        case 1:boolean flag11=true;
                                                                                String location="";
                                                                                while(flag11)
                                                                                {
                                                                                    System.out.println("Enter your location");
                                                                                    location=scanner.nextLine();
                                                                                    if(registerService.validString(location))
                                                                                    {
                                                                                        flag11=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input ");
                                                                                    }
                                                                                }

                                                                                boolean flag12=true;
                                                                                String skillset1="";
                                                                                while(flag12)
                                                                                {
                                                                                    System.out.println("Enter your skillset1");
                                                                                    skillset1=scanner.nextLine();
                                                                                    if(registerService.validString(skillset1))
                                                                                    {
                                                                                        flag12=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }

                                                                                boolean flag13=true;
                                                                                String skillset2="";
                                                                                while(flag13)
                                                                                {
                                                                                    System.out.println("Enter your skillset2");
                                                                                    skillset2=scanner.nextLine();
                                                                                    if(registerService.validString(skillset2))
                                                                                    {
                                                                                        flag13=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }

                                                                                boolean flag14=true;
                                                                                String skillset3="";
                                                                                while(flag14)
                                                                                {
                                                                                    System.out.println("Enter your skillset3");
                                                                                    skillset3=scanner.nextLine();
                                                                                    if(registerService.validString(skillset3))
                                                                                    {
                                                                                        flag14=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }
                                                                                Resume resume=new Resume(location,skillset1,skillset2,skillset3);
                                                                                registerService.addResume(resume,user_name);
                                                                                break;

                                                                        case 2: registerService.viewResume(user_name);
                                                                                break;

                                                                        case 3: boolean flag112=true;
                                                                                String location1="";
                                                                                while(flag112)
                                                                                {
                                                                                    System.out.println("Enter your location");
                                                                                    location1=scanner.nextLine();
                                                                                    if(registerService.validString(location1))
                                                                                    {
                                                                                        flag112=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input ");
                                                                                    }
                                                                                }

                                                                                boolean flag113=true;
                                                                                String skillset11="";
                                                                                while(flag113)
                                                                                {
                                                                                    System.out.println("Enter your skillset1");
                                                                                    skillset11=scanner.nextLine();
                                                                                    if(registerService.validString(skillset11))
                                                                                    {
                                                                                        flag113=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }

                                                                                boolean flag131=true;
                                                                                String skillset21="";
                                                                                while(flag131)
                                                                                {
                                                                                    System.out.println("Enter your skillset2");
                                                                                    skillset21=scanner.nextLine();
                                                                                    if(registerService.validString(skillset21))
                                                                                    {
                                                                                        flag131=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }

                                                                                boolean flag141=true;
                                                                                String skillset31="";
                                                                                while(flag141)
                                                                                {
                                                                                    System.out.println("Enter your skillset31");
                                                                                    skillset31=scanner.nextLine();
                                                                                    if(registerService.validString(skillset31))
                                                                                    {
                                                                                        flag141=false;
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        System.out.println("Invalid input");
                                                                                    }
                                                                                }
                                                                                registerService.updateResume(location1,skillset11,skillset21,skillset31,user_name);
                                                                                System.out.println("Sucessfully resume updated");
                                                                                break;

                                                                        case 4: registerService.deleteResume(user_name);
                                                                                break;

                                                                        case 5: flag3=false;
                                                                                break;
                                                                    }
                                                                }
                                                                break;

                                                        case 2: boolean flagg=true;
                                                                while(flagg)
                                                                {
                                                                    System.out.println("***********************");
                                                                    System.out.println("1) List All jobs");
                                                                    System.out.println("2) Search By Role");
                                                                    System.out.println("3) Search By Required");
                                                                    System.out.println("4) Status");
                                                                    System.out.println("5) Go back");
                                                                    System.out.println("***********************");
                                                                    int flaggch=scanner.nextInt();
                                                                    scanner.nextLine();
                                                                    switch (flaggch)
                                                                    {
                                                                        case 1: registerService.listAllJobs();
                                                                                System.out.println("****************");
                                                                                System.out.println("1) Apply");
                                                                                System.out.println("2) Go Back");
                                                                                System.out.println("*****************");
                                                                                int flaggchh=scanner.nextInt();
                                                                                scanner.nextLine();
                                                                                switch (flaggchh)
                                                                                {
                                                                                    case 1: System.out.println("Enter the role to apply");
                                                                                            String applying=scanner.nextLine();
                                                                                            if(! registerService.checkValidForApply(user_name,applying))
                                                                                            {
                                                                                                registerService.applyForJob(user_name,applying);
                                                                                            }
                                                                                            else{
                                                                                                System.out.println("already applied");
                                                                                            }
                                                                                            break;

                                                                                    case 2:break;

                                                                                    default: System.out.println("Invalid");
                                                                                }
                                                                                break;

                                                                        case 2: System.out.println("search for Role");
                                                                                String srole=scanner.nextLine();
                                                                                registerService.searchByRole(srole);
                                                                                System.out.println("****************");
                                                                                System.out.println("1) Apply");
                                                                                System.out.println("2) Go Back");
                                                                                System.out.println("*****************");
                                                                                int flaggchhh=scanner.nextInt();
                                                                                scanner.nextLine();
                                                                                switch (flaggchhh)
                                                                                {
                                                                                    case 1: System.out.println("Enter the role to apply");
                                                                                            String applying=scanner.nextLine();
                                                                                            if(! registerService.checkValidForApply(user_name,applying))
                                                                                            {
                                                                                                registerService.applyForJob(user_name,applying);
                                                                                            }
                                                                                            else{
                                                                                                System.out.println("already applied");
                                                                                            }
                                                                                            break;

                                                                                    case 2:break;

                                                                                    default: System.out.println("Invalid");
                                                                                }
                                                                                break;

                                                                        case 3: System.out.println("search for Required");
                                                                                String sreq=scanner.nextLine();
                                                                                registerService.searchByRequired(sreq);
                                                                                System.out.println("****************");
                                                                                System.out.println("1) Apply");
                                                                                System.out.println("2) Go Back");
                                                                                System.out.println("*****************");
                                                                                int flaggchhh1=scanner.nextInt();
                                                                                scanner.nextLine();
                                                                                switch (flaggchhh1)
                                                                                {
                                                                                    case 1: System.out.println("Enter the role to apply");
                                                                                            String applying=scanner.nextLine();
                                                                                            if(! registerService.checkValidForApply(user_name,applying))
                                                                                            {
                                                                                                registerService.applyForJob(user_name,applying);
                                                                                            }
                                                                                            else{
                                                                                            System.out.println("already applied");
                                                                                            }
                                                                                            break;

                                                                                    case 2:break;

                                                                                    default: System.out.println("Invalid");
                                                                                }
                                                                                break;

                                                                        case 4: registerService.status(user_name);
                                                                                break;

                                                                        case 5: flagg=false;
                                                                                break;
                                                                    }
                                                                }
                                                                break;

                                                        case 3: exitoneone=false;
                                                                break;
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
                                System.out.println("***********************");
                                System.out.println("Choose operation");
                                System.out.println("1)Employee Register");
                                System.out.println("2)Employee Login");
                                System.out.println("3)Go Back ");
                                System.out.println("***********************");
                                int choiceTwo = scanner.nextInt();
                                switch (choiceTwo)
                                {
                                    case 1: boolean flag=true;
                                            String companyname="";
                                            while(flag)
                                            {
                                                scanner.nextLine();
                                                System.out.println("Enter your Company name");
                                                companyname=scanner.nextLine();
                                                if(registerService.validString(companyname))
                                                {
                                                    flag=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid name");
                                                }
                                            }

                                            boolean flag1=true;
                                            String gmail="";
                                            while(flag1)
                                            {
                                                System.out.println("Enter your mail");
                                                gmail=scanner.nextLine();
                                                if(registerService.validMail(gmail))
                                                {
                                                    flag1=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid gmail");
                                                }
                                            }

                                            boolean flag2=true;
                                            String password="";
                                            while(flag2)
                                            {
                                                System.out.println("Enter your Password");
                                                password=scanner.nextLine();
                                                if(registerService.validPassword(password))
                                                {
                                                    flag2=false;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid password");
                                                }
                                            }

                                            EmployeeRegister employeeRegister = new EmployeeRegister(companyname,gmail,password);
                                            registerService.addEmpDetails(employeeRegister);
                                            System.out.println("Register sucessful");
                                            break;

                                    case 2: System.out.println("Enter Employee gmail");
                                            scanner.nextLine();
                                            String user_gmail = scanner.nextLine();
                                            System.out.println("Enter password");
                                            String user_password = scanner.nextLine();
                                            if(registerService.validateEmployee(user_gmail, user_password))
                                            {
                                                System.out.println("Login Sucessful");
                                                log.info("Employee login");
                                                boolean exit01=true;
                                                while (exit01)
                                                {
                                                    System.out.println("1) job posting");
                                                    System.out.println("2) View Job ");
                                                    System.out.println("3) List Of User Applied");
                                                    System.out.println("4) Go back");
                                                    int exitchoice=scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch (exitchoice)
                                                    {
                                                        case 1: System.out.println("Enter the role");
                                                                String role=scanner.nextLine();
                                                                System.out.println("Enter the required");
                                                                String required=scanner.nextLine();
                                                                System.out.println("Enter the experience");
                                                                String experience=scanner.nextLine();
                                                                System.out.println("Enter the lpa");
                                                                String lpa=scanner.nextLine();
                                                                Job job=new Job(role,required,experience,lpa);
                                                                registerService.postJob(job,user_gmail);
                                                                break;

                                                        case 2: boolean lastone=true;
                                                                while(lastone)
                                                                {
                                                                    System.out.println("1) View Application");
                                                                    System.out.println("2) Update Application");
                                                                    System.out.println("3) Delete Application");
                                                                    System.out.println("4) Go Back");
                                                                    int option=scanner.nextInt();
                                                                    scanner.nextLine();
                                                                    switch (option)
                                                                    {
                                                                        case 1: registerService.viewApplication(user_gmail);
                                                                                break;

                                                                        case 2: System.out.println("Enter Role for updation");
                                                                                String crole=scanner.nextLine();
                                                                                if(registerService.checkupdateApplication(crole))
                                                                                {
                                                                                    System.out.println(crole+" Updating into...");
                                                                                    System.out.println("Enter the role");
                                                                                    String role1=scanner.nextLine();
                                                                                    System.out.println("Enter the required");
                                                                                    String required1=scanner.nextLine();
                                                                                    System.out.println("Enter the experience");
                                                                                    String experience1=scanner.nextLine();
                                                                                    System.out.println("Enter the lpa");
                                                                                    String lpa1=scanner.nextLine();
                                                                                    registerService.updateApplication(crole,role1,required1,experience1,lpa1);
                                                                                }
                                                                                else{
                                                                                    System.err.println("No such job role");
                                                                                    log.warn("No such job role");
                                                                                }
                                                                                break;

                                                                        case 3: System.out.println("Enter the role of application to delete");
                                                                                String drole=scanner.nextLine();
                                                                                if(registerService.checkupdateApplication(drole))
                                                                                {
                                                                                    System.out.println(drole+" Deleting ....");
                                                                                    registerService.deleteApplication(drole);
                                                                                }
                                                                                else
                                                                                {
                                                                                    System.err.println("No such job role");
                                                                                    log.warn("No such job role");
                                                                                }
                                                                                break;
                                                                        case 4: lastone=false;
                                                                                break;
                                                                    }
                                                                }
                                                                break;

                                                        case 3: registerService.userlist(user_gmail);
                                                                System.out.println("Enter the status");
                                                                String status=scanner.nextLine();
                                                                registerService.accpetOrReject(status,user_gmail);
                                                                break;

                                                        case 4: exit01=false;
                                                                break;

                                                        default: System.out.println("Invalid option");
                                                    }
                                                }
                                            }
                                            break;

                                    case 3:

                                    case 4: exitTwo=false;
                                            break;

                                    default: System.out.println("Invalid choice");
                                }
                            }
                            break;

                    case 3:exit=false;
                           break;

                    default:System.out.println("Invalid choice");
                            break;
                }
            }
            log.info("Application End");
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