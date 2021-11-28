
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
	foreign key (Emp_ID) references Person(ID)
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
	foreign key(Client_ID) references Person(ID)
);

/* Need more thinking */
create table Expertise
(
	Specialisation_ID varchar(6) primary key,
	Qualification varchar(30), 
)

/*=====================Mohak=============================*/


/*=====================Aditya=============================*/



/*=====================Uday=============================*/

