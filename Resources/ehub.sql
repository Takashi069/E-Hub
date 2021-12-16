
/*=====================Akash=============================*/


create table Login
(
	ID varchar(6),
	Username varchar(30),
	Password varchar(30),
	Password_Hint varchar(60),
	primary key(ID),
	foreign key (ID) references Person(ID) on delete cascade
);

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

alter table project add column project_log varchar(10000);

update project set project_log = 'This is a sample description#';

/* For Testing, Need not execute */
select * from person ;
select * from employee e ;
select * from client c ;
select * from project;
select * from login l ;
select * from project;
select * from login l ;
select * from project_team pt ;

delete from project;
delete from project_team;

update project set project_leader = null where project_id = 'PRO002';

update employee set engaged_in_project = 'N';
update project set status_of_software = 'NOT APPROVED' ;


select p.id, p.name, p.dob, c.company ,c.total_orders 
from person p, client c
where p.id = c.client_id and c.client_id = 'CLI001';

select substring(client_id,4,6) from client order by client_id desc;

select p.id, p.name, p.dob, e.experience ,e.specialisation_id 
from person p, employee e 
where p.id = e.emp_id and e.emp_id = 'EMP002';

select p.id, p.name, p.dob, c.company ,c.total_orders  
                         from person p, client c
                         where p.id = c.client_id and c.client_id = 'CLI001';

select count(distinct(client_id))  from client c ;
select client_id from client;
select project_id from project where status_of_software = 'NOT APPROVED' order by project_id;
select project_id from project where status_of_software !='NOT APPROVED' order by project_id ;
select project_id,project_name,date_of_release,status_of_software,client_id from project;

insert into person values
('EMP001','Akash Harikumar','Gokulam','Edavanassery', 'Kollam','Kerala','690519','Indian','07/08/2001');
insert into employee values
('EMP001', 6, 'WEB', 'N','07/08/2021');

insert into employee values
('EMP001','University Degree','WEB','N','07/08/2021' );

update project set status_of_software = 'APPROVED';
update project set status_of_software = 'NOT APPROVED' where project_id ='PRO002';

delete from employee ;
delete from client;
delete from person;
delete from project;

drop table client;
drop table employee ;
DROP TABLE person;
drop table login;
drop table project;

insert into person values
('ADM001','Akash Harikumar','Gokulam','Edavanassery', 'Kollam','Kerala','690519','Indian','07/08/2001');

insert into Project(Project_ID, Client_ID, Project_Name,Project_Log ,Date_of_Release, Status_of_software, Domain) values('PRO008','CLI002','John Memoir','A website to display all of Sir Arthur's novel for the whole world to read about
#','2022-05-06','NOT APPROVED','WEB')

select project_log, project_id from project p;
delete from person where id = 'EMP003';
select Emp_ID,experience from employee where Specialisation_ID = 'WEB' and Engaged_In_Project = 'N' order by experience asc;

update project_team set project_id = 'PRO001',emp_id='EMP001';
insert into project_team(project_id,emp_id) values('PRO001','EMP001');
select count(Emp_ID) from employee where Specialisation_ID = 'WEB' and Engaged_In_Project = 'N'

select e.emp_id, e.experience from employee e , project_team pt where pt.emp_id  = e.emp_id ;

select client_id,count(Project_ID) as Totalprojcount from Project where Status_of_Software='PAID' group by client_id order by Totalprojcount desc;


/*=====================Mohak=============================*/
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


/*=====================Aditya=============================*/

insert into Login Values ('ADM001','frontman', 'ehub', 'projname');

insert into Login Values ('CLI001','Mark', 'ehub', 'ehub');
insert into Login Values ('CLI002','Donald', 'ehub', 'ehub');

create table Project_Team(Project_id varchar(6),Emp_ID varchar(6), Project_leader varchar(6),
						 primary key(Project_id, Emp_ID),
						 foreign key (Project_leader) references Employee(Emp_ID) on delete cascade
						 )
						 
select * from project_team;

insert into employee values('EMP002', 4,'WEB', 'Y', '2019-05-01');
insert into employee values('EMP003', 4,'WEB', 'Y', '2019-05-01');
insert into employee values('EMP004', 4,'WEB', 'Y', '2019-05-01');
insert into employee values('EMP005', 8,'WEB', 'Y', '2019-05-01');

insert into Project_team values('PRO001', 'EMP001', 'EMP005');
insert into Project_team values('PRO001', 'EMP002', 'EMP005');
insert into Project_team values('PRO001', 'EMP003', 'EMP005');
insert into Project_team values('PRO001', 'EMP004', 'EMP005');
insert into Project_team values('PRO001', 'EMP005', 'EMP005');

/*=====================Uday=============================*/

