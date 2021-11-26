# E-Hub

## Summary of Project: 

E-hub is a software company that provides various types of software solutions to clients across India. Design a system that enables the end user to view, add, edit or delete employee details of the organisation. The user can retrieve employee details just by entering their employee ID. Similarly, maintain their client details so that the end user can view, add, edit or delete client details. Also they can generate reports on their deliverables, employee and client details.   


## The Plan so Far: 

* Person class will be public and abstract

* Admin, Client and Employee will inherit from Person(All three will be Public)

* * Admin will communicate with database

* * Project will communicate between the objects of the classes

~~(Idea Trashed):To achieve overloading adding or removing employees or clients can have same function name but different parameters~~

 * **Better Alternative:** <br>Add Person function in Admin class, To achieve overloading, one parameter can have "employee" while other can have "client"

* **Optional**: If possible try creating own exception(eg: emails from employee)

* **Priority**:giving more importance to clients who have given more project

* **GUI Resolution**:<br> `1280 X 1024`

* **GUI Made using Java Swings**

## Proposed File Structure: 

` Each package may contain more than one file `

```
src 
  
  Person.java
  
  Client
    client.java
  
  Employee
    employee.java
  
  Admin
    admin.java
  
  Project
    project.java
  
  Report
    report.java
  
  GUI
    gui.java
```
<br>

### For References, do check the Use Case Diagram and the Class Diagram present in the Resources Folder

<br>

---
# DEADLINE : 05/12/2021 19:00:00 
