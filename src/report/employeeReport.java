package report;

import employee.employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gui.secret;

public class employeeReport{

    public employee displayReport(employee E){
        Connection c = null;
        secret s = new secret();
        employee retreiveEmployee = new employee();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Date date;
        String query1 = "select p.id, p.name, p.dob, e.experience ,e.specialisation_id " + 
                         " from person p, employee e " +
                         "where p.id = e.emp_id and e.emp_id = ?";

        String query2 = "select count(project_id) from project_team where emp_id=?";
        String query3 = "select count(distinct(project_id)) from project_team where project_leader=?";
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.prepareStatement(query1);
            ps.setString(1, E.getID());
            rs = ps.executeQuery();
            if(rs.next()){
                retreiveEmployee.setID(rs.getString(1));
                retreiveEmployee.setName(rs.getString(2));
                date  = rs.getDate(3);
                retreiveEmployee.setDOB(date.toString());
                retreiveEmployee.setExperience(rs.getInt(4));
                retreiveEmployee.setDomain(rs.getString(5));
            }
            ps = c.prepareStatement(query2);
            ps.setString(1, E.getID());
            rs = ps.executeQuery();
            if(rs.next()){
                retreiveEmployee.setProjectsWorked(Integer.parseInt(rs.getString(1)));
            }
            ps = c.prepareStatement(query3);
            ps.setString(1, E.getID());
            rs = ps.executeQuery();
            if(rs.next()){
                retreiveEmployee.setProjectsLed(Integer.parseInt(rs.getString(1)));
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return retreiveEmployee;
    }

}
