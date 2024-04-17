create table departments(
departmentid int primary key,
departmentname varchar(100)
);


CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email NVARCHAR(100) UNIQUE NOT NULL,
    DateOfBirth DATE NOT NULL,
    DepartmentID INT,
    CONSTRAINT FK_Department FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);


select * from departments;

select * from Employees;

ALTER TABLE Employees ADD PhoneNumber NVARCHAR(20);

ALTER TABLE Employees ADD CONSTRAINT PK_Employees PRIMARY KEY (EmployeeID, Email);

insert into departments (departmentid,departmentname) values (1,'it'),(2,'finance');

INSERT INTO Employees (EmployeeID, FirstName, LastName, Email, DateOfBirth, DepartmentID, PhoneNumber)
VALUES
    (1, 'Muzamil', 's', 'john@example.com', '1990-01-01', 1, '123-456-7890'),
    (2, 'tharun', 'raj', 'jane@example.com', '1992-05-15', 2, '987-654-3210'),
    (3, 'sowmiya', 'mental', 'alice@example.com', '1985-09-20', 1, '555-555-5555'),
    (4, 'jaya', 'lakshmi', 'bob@example.com', '1988-11-10', 2, '444-444-4444'),
    (5, 'gow', 'tham', 'emily@example.com', '1994-03-25', 2, '777-777-7777');



UPDATE Employees
SET PhoneNumber = '555-123-4567'
WHERE EmployeeID = 1;


DELETE FROM Employees
WHERE EmployeeID = 5;


ALTER TABLE Employees
ADD CONSTRAINT CHK_DateOfBirth CHECK (DateOfBirth <= GETDATE());


ALTER TABLE Employees
ADD CONSTRAINT DF_PhoneNumber DEFAULT '123-456-7890' FOR PhoneNumber;

UPDATE Employees
SET DateOfBirth = '2024-08-24'
WHERE EmployeeID = 1;