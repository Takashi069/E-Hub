package report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import client.client;
import gui.secret;

public class clientReport  {


    public client displayReport(client C){
        Connection c = null;
        secret s = new secret();
        client retreiveClient = new client();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Date date;
        String query1 = "select p.id, p.name, p.dob, c.company ,c.total_orders" + 
                         " from person p, client c " +
                         "where p.id = c.client_id and c.client_id = ?";
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.prepareStatement(query1);
            ps.setString(1, C.getID());
            rs = ps.executeQuery();
            if(rs.next()){
                retreiveClient.setID(rs.getString(1));
                retreiveClient.setName(rs.getString(2));
                // System.out.println(rs.getString(2));
                date  = rs.getDate(3);
                retreiveClient.setDOB(date.toString());
                retreiveClient.setCompany(rs.getString(4));
                retreiveClient.setTotal_Orders(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println("Is it here\n\n");
        }
        return retreiveClient;
    }

}
