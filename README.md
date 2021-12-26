# E-Hub

## Summary of Project: 

E-hub is a software company that provides various types of software solutions to clients across India. Design a system that enables the end user to view, add, edit or delete employee details of the organisation. The user can retrieve employee details just by entering their employee ID. Similarly, maintain their client details so that the end user can view, add, edit or delete client details. Also they can generate reports on their deliverables, employee and client details.<br>The application we made is primarily aimed towards the company admin and the various clients working with the company.

<br>

> ### For References, do check the Use Case Diagram and the Class Diagram present in the Resources Folder

<br>

# How to use the Application ?

* Download the repository from github
* create a file known as secret.java in the gui folder with the following lines: 
```java
package gui;

public class secret {
    public String url = "JDBC connection path to your database";
    public String dbUser = "postgresql Database username";
    public String dbPass = "postgresql Database Password";
    public String prefix = "path to the assets folder from your home directory";
}

```

## Setting up the Database: 

* Create a new Database using pgAdmin or any postgresql client for your E-Hub application
* Execute the following queries to set up the Database for usage: 

```sql
create table Person
(
	ID varchar(6),
	name varchar(40),
	Street_Name varchar(30),
	Locality varchar(30),
	District varchar(30),
	State varchar(30),
	PINCODE varchar(10),
	Nationality varchar(20),
	DOB date,
	primary key(ID)
);

create table Employee
(
	Emp_ID varchar(6),
	Experience int,
	Specialisation_ID varchar(30) not null,
	Engaged_In_Project char,
	Emp_Join_Date date,
	primary key(Emp_ID),
	foreign key (Emp_ID) references Person(ID) on delete cascade
);

create table Client
(
	Client_ID varchar(6) primary key,
	Company varchar(30),
	Total_Orders int default 0,
	foreign key(Client_ID) references Person(ID) on delete cascade
);

create table Login
(
	ID varchar(6),
	Username varchar(30),
	Password varchar(30),
	Password_Hint varchar(60),
	primary key(ID),
	foreign key (ID) references Person(ID) on delete cascade
);

create table Project
(
	Project_ID varchar(6),
	Client_ID varchar(20),
	Project_Name varchar(20),
	project_log varchar(10000),
	Date_of_Release varchar(20),
	Status_of_Software varchar(30),
	Domain varchar(20),
	Date_of_Commencement varchar(20),
	Project_leader varchar(6), 
	foreign key (Client_ID) references Client on delete cascade,
	FOREIGN KEY (Project_leader) references Employee(Emp_ID),
	primary key(Project_ID)
);

create table Project_Team
(
  Project_id varchar(6),
  Emp_ID varchar(6),
  Project_leader varchar(6),
	primary key(Project_id, Emp_ID),
	foreign key (Project_leader) references Employee(Emp_ID) on delete cascade
);
						 
```

* ### After creating the schema, you need to insert the details of the admin into both the Person relation and Login Relation. <br> To do that, follow the queries given below and make changes to the data wherever necessary.

```sql
insert into person values
('ADM001','Name of the Admin','Address Line 1','Address Line 2', 'District','State','PINCODE (Strictly 6 digits)','Nationality','Date of Birth');

insert into Login Values ('ADM001','Admin Username', 'A password of your choice', 'A password hint');

```
> ### <b>Note</b> : Once a Client has been created by the Admin, the Client can login with the username as the Client's name and the password as `ehub`.<br>Feel Free to modify the source-code to include your own password generators and username generators after forking the project  
<br>

# OOPS Concepts used: 
* Inheritance &rarr; Heirarchical Inheritance
* Polymorphism &rarr; Function Overloading
*  Abstraction &rarr; Person class is abstract and there is an interface in the GUI  
# Contributions: 

## Akash: (AM.EN.U4CSE20204)

Admin GUI and working of the admin class, it's functionalities and connections with database using JDBC and the GUI (pertaining to admin), handled exceptions within Project Allocation.
<br>
## Mohak: (AM.EN.U4CSE20247)

Login GUI, Project class implementation, connections using JDBC pertaining to project class

## Adithya (AM.EN.U4CSE20258)

Login JDBC connections, Client Dashboard GUI, Request project GUI and connection using JDBC and view projects connection to the DB using JDBC, responsible for the GUI design overhaul.

## Uday (AM.EN.U4CSE20273)

Employee Class, View Project GUI and functions, Client GUI, implementation and connection using JDBC, Client and Employee Report.
all the Report GUIs.
<br>
<br>
<br>

> #### <b>Note</b>: The Project is no Longer being maintained by the contributers as it was a University Semester Project to familiarise with the Java Programming Language.
