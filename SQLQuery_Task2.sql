create database example;

use example;

create table Employee(
Empcode int ,
EmpFname varchar(20),
EmpLname varchar(20),
Job varchar(40),
Manager varchar(20),
HireDate date,
Salary int ,
Commision int,
Deptcode int
);

create table Department(
Deptcode int,
DeptName varchar(30),
Loc varchar(40)
);


alter table Employee
alter column Empcode int not null;

alter table Employee 
add constraint PK_Employee primary key(Empcode);

alter table Department 
alter column Deptcode int not null;

alter table Department 
add constraint PK_Department primary key(Deptcode);

alter table Department 
add constraint UN_Department unique(DeptName);

alter table Department 
alter column loc varchar(40) not null;

alter table Employee 
add constraint FK_Employee foreign key(Deptcode)
references Department(Deptcode);

insert into Department(Deptcode,Deptname,loc) 
values (10, 'FINANCE', 'EDINBURGH'),
(20,'SOFTWARE','PADDINGTON'),
(30, 'SALES', 'MAIDSTONE'),
(40,'MARKETING', 'DARLINGTON'),
(50,'ADMIN', 'BIRMINGHAM');

select * from Department;

insert into Employee(Empcode,EmpFname,EmpLname,Job,Manager,HireDate,Salary,Commision,Deptcode) values
(9369, 'TONY', 'STARK', 'SOFTWARE ENGINEER', 7902, '1980-12-17', 2800,0,20),
       (9499, 'TIM', 'ADOLF', 'SALESMAN', 7698, '1981-02-20', 1600, 300,30),    
       (9566, 'KIM', 'JARVIS', 'MANAGER', 7839, '1981-04-02', 3570,0,20),
       (9654, 'SAM', 'MILES', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
       (9782, 'KEVIN', 'HILL', 'MANAGER', 7839, '1981-06-09', 2940,0,10),
       (9788, 'CONNIE', 'SMITH', 'ANALYST', 7566, '1982-12-09', 3000,0,20),
       (9839, 'ALFRED', 'KINSLEY', 'PRESIDENT', 7566, '1981-11-17', 5000,0, 10),
       (9844, 'PAUL', 'TIMOTHY', 'SALESMAN', 7698, '1981-09-08', 1500,0,30),
       (9876, 'JOHN', 'ASGHAR', 'SOFTWARE ENGINEER', 7788, '1983-01-12',3100,0,20),
       (9900, 'ROSE', 'SUMMERS', 'TECHNICAL LEAD', 7698, '1981-12-03', 2950,0, 20),
       (9902, 'ANDREW', 'FAULKNER', 'ANAYLYST', 7566, '1981-12-03', 3000,0, 10),
       (9934, 'KAREN', 'MATTHEWS', 'SOFTWARE ENGINEER', 7782, '1982-01-23', 3300,0,20),
       (9591, 'WENDY', 'SHAWN', 'SALESMAN', 7698, '1981-02-22', 500,0,30),
       (9698, 'BELLA', 'SWAN', 'MANAGER', 7839, '1981-05-01', 3420, 0,30),
       (9777, 'MADII', 'HIMBURY', 'ANALYST', 7839, '1981-05-01', 2000, 200, NULL),
       (9860, 'ATHENA', 'WILSON', 'ANALYST', 7839, '1992-06-21', 7000, 100, 50),
       (9861, 'JENNIFER', 'HUETTE', 'ANALYST', 7839, '1996-07-01', 5000, 100, 50); 

select * from Employee;

-- 1.Create a query that displays EMPFNAME, EMPLNAME, DEPTCODE, DEPTNAME,
-- LOCATION from EMPLOYEE, and DEPARTMENT tables. Make sure the results 
-- are in ascending order based on the EMPFNAME and LOCATION of the department.

SELECT E.EMPFNAME, E.EMPLNAME, D.DEPTCODE, D.DEPTNAME, D.LOC
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPTCODE = D.DEPTCODE
ORDER BY E.EMPFNAME ASC, D.LOC ASC;

-- 2.Display EMPFNAME and “TOTAL SALARY” for each employee

select EMPFNAME ,salary+commision as "totoal salary" 
from Employee;

-- 3.Display MAX and 2nd MAX SALARY from the EMPLOYEE table.

SELECT MAX(SALARY) AS "MAX SALARY", (SELECT MAX(SALARY) FROM EMPLOYEE WHERE SALARY < (SELECT MAX(SALARY) FROM EMPLOYEE)) AS "2nd MAX SALARY"
FROM EMPLOYEE;


-- 4.Display the TOTAL SALARY drawn by an analyst working in dept no 20

select salary+commision as "Total salary"
from employee
where job='analyst' and Deptcode=20;


-- 5.Compute the average, minimum, and maximum salaries of the group of employees having the job of ANALYST.

select avg(salary) as "Average sal",min(salary) as "Minimum sal",max(salary) as "Maximum sal"
from employee
where job='analyst'
group by job;

-- 6.Query to find all departments that are located in Edinburgh:

select *
from Department
where loc='EDINBURGH';

-- 7.Query to find all employees who work in the FINANCE department:

SELECT E.EMPFNAME,E.EMPLNAME, D.DEPTCODE, D.DEPTNAME, D.LOC
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPTCODE = D.DEPTCODE
where DeptName='FINANCE';

-- 8.Query to find the average salary of employees in each department:

select job,avg(salary)
from Employee
group by job;


-- 9.Query to find the top 10 highest-paid employees:

select top 10 employee.*
from Employee
order by Salary desc;

-- 10.Query to find all employees who did not get a promotion in the last year:

-- 12.Return a list of all employees who have been with the company for more than 5 years.

-- 13.Return a list of all departments, ordered by the number of employees in each department.

select count(d.DeptName) as "NUmber of Employee",d.Deptcode
from Employee e join Department d
on e.Deptcode=d.Deptcode
group by d.Deptcode;

-- 14. Return a list of all job titles, ordered by the number of employees in each job title.

select job,count(job) as "Number of employee"
from employee
group by job;


--15.Return a list of all managers, ordered by the number of employees managed by each manager.

select manager,count(Manager) as "Number of manager manage by each manager"
from Employee
group by manager;



