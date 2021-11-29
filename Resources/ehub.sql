
/*=====================Akash=============================*/


create table Login
(
	ID varchar(6),
	Username varchar(30),
	Password varchar(30),
	Password_Hint varchar(60),
	primary key(ID)
);

create table Person
(
	ID varchar(6),
	fname varchar(20),
	lname varchar(20),
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
	Qualification varchar(30),
	Specialisation_ID varchar(6) not null,
	Engaged_In_Project char,
	Emp_Join_Date date,
	primary key(Emp_ID),
	foreign key (Emp_ID) references Person(ID) on delete cascade
);

create table Programming_Languages
(
	Language_ID varchar(6) primary key,
	Language_Name varchar(20)
)

create table Client
(
	Client_ID varchar(6) primary key,
	Company varchar(30),
	Total_Orders int default 0,
	foreign key(Client_ID) references Person(ID) on delete cascade
);

/* Need more thinking */
create table Expertise
(
	Specialisation_ID varchar(6) primary key,
	Qualification varchar(30), 
)

/* For Testing, Need not execute */
select * from person ;
select * from employee e ;
select * from client c ;
insert into person values
('EMP001','Akash','Harikumar','Gokulam','Edavanassery', 'Kollam','Kerala','690519','Indian','07/08/2001');
insert into employee values
('EMP001', 'University Degree', 'WEB', 'N','07/08/2021');

insert into employee values
('EMP001','University Degree','WEB','N','07/08/2021' );

delete from employee ;
delete from client;
delete from person;

drop table client;
drop table employee ;
/*=====================Mohak=============================*/
create table Project
(
	Project_ID varchar(6),
	Client_ID varchar(20),
	Project_Name varchar(20),
	Date_of_Commencement varchar(20),
	Date_of_Release varchar(20),
	Status_of_Software varchar(30),
	Domain varchar(20),
	Project_leader varchar(20),
	primary key(Project_ID)
);


/*=====================Aditya=============================*/



/*=====================Uday=============================*/

