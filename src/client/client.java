
package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import person.Person;
import gui.secret;
import Project.project;
import java.util.Vector;

public class client extends Person {
    secret s = new secret();

    public client() {
        super();
    }

    private String clientID;
    private String password;
    private int totalProjectsRequested;
    private int priority;
    private int Total_Orders;
    private String Company;
    private String[] person_id_list;
    private String[] person_name_list;

    public String getID() {
        return this.clientID;
    }

    public void setID(String clientID) {
        this.clientID = clientID;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalProjectsRequested() {
        return this.totalProjectsRequested;
    }

    public void setTotalProjectsRequested(int totalProjectsRequested) {
        this.totalProjectsRequested = totalProjectsRequested;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTotal_Orders() {
        return this.Total_Orders;
    }

    public void setTotal_Orders(int Total_Orders) {
        this.Total_Orders = 0;
    }

    public String getCompany() {
        return this.Company;
    }

    public String[] getPersonIdList() {
        return this.person_id_list;
    }

    public String[] getPersonNameList() {
        return this.person_name_list;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    protected int findMissingNumber(int[] arr) { //arr is sorted in ascending order, the arrays will have the numbers 
        int i;
        for (i = 1; i <= arr.length; i++) {
            System.out.println(arr[i - 1] + "\t" + i); 
            if (i != arr[i - 1]) {
                return i;
            }
        }
        return i;
    }

    public String assignID(){
        int count = 0;
        String ogtype = "client";
        String queryid = "client_id";
        String countString;
        String query = "select count(distinct(" +queryid+")) from " + ogtype;
        String query2 = "select substring(" + queryid +",4,6) from " + ogtype + " order by "+queryid +" desc";
        System.out.println(query+"\n"+query2);
        Statement stmt = null;
        Connection c = null;
        ResultSet rs = null;
        int missingID = 0;
        try{
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next())
                count = rs.getInt("count");
            int[] sortedArray = new int[count];
            rs = stmt.executeQuery(query2);
            int i = count-1;
            /*
                This while loop creates an array from the list of 
                data entries we recieved. The array is sorted in ascending 
                order.
            */
            while(rs.next()){
                sortedArray[i] = Integer.parseInt(rs.getString(1));
                i--;
            }
            missingID = findMissingNumber(sortedArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        countString = String.format("%d", missingID);
        if(countString.length()<3){
            for (int i = countString.length(); i < 3; i++){
                countString = "0"+countString;
            }
        }
        String finalID = "";
        finalID = "CLI" + countString;
        return finalID;
    }

    public void AddProject(project p) {
        Connection c = null;
        Statement stmt = null;

        // We need to add the data in the Project table first
        String count = "select count(Project_ID) as id from Project;"; // it is used to give the size of the array sortedArray
        String query2 = "select substring(Project_ID,4,6) from Project order by Project_ID desc";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(count);
            String newId = "";
            rs.next();
            int countNum = Integer.parseInt(rs.getString("id"));
            int j = countNum - 1;
            int[] sortedArray = new int[countNum];

            rs = stmt.executeQuery(query2);
            while (rs.next()) {
                sortedArray[j] = Integer.parseInt(rs.getString(1));
                System.out.println(sortedArray[j]);
                j--;
            }
            int missingID = findMissingNumber(sortedArray);
            System.out.println(missingID);
            newId = String.format("PRO%03d", missingID);
            System.out.println(newId);
            p.setProjectID(newId);

            String ProjectQuery = String.format(
                    "insert into Project(Project_ID, Client_ID, Project_Name, Date_of_Release, Status_of_software, Domain) values('%s','%s', '%s','%s','%s','%s')",
                    p.getProjectID(), p.getClientID(), p.getProjectName(), p.getProjectDeadline(), "NOT APPROVED",
                    p.getProjectType());

            stmt = c.createStatement();

            // To set the date as the current date
            PreparedStatement ps = c.prepareStatement(ProjectQuery);
            // ps.setDate(1, new java.sql.Date(date.getTime()));

            int output = 0;
            output = ps.executeUpdate();
            System.out.println(output + " Row(s) Updated");
            stmt.close();
            // Total Orders try
            Total_Orders += 1;
            PreparedStatement ps2 = c.prepareStatement("update Client set Total_Orders=? where client_id=?");
            ps2.setInt(1, Total_Orders);// 1 specifies the first parameter in the query i.e. name
            ps2.setString(2, p.getClientID());

            int i = ps2.executeUpdate();
            System.out.println(i + " records updated");
            // Total Orders
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeProject(project P) {
        Connection c = null;
        String query = "delete from Project where Project_ID = ?";
        // The following lines of code are temporary:

        // String project_id = P.getProjectID;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, P.getProjectID());
            int output = ps.executeUpdate();
            System.out.println(output + " Row(s) Removed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public project showPrimaryDetails(project p) {
        Connection c = null;
        project retreiveproject = new project();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query1 = "select project_id,project_name,status_of_software from project where project_id=?";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.prepareStatement(query1);
            ps.setString(1, p.getProjectID());
            rs = ps.executeQuery();
            rs.next();
            retreiveproject.setProjectID(rs.getString(1));
            retreiveproject.setProjectName(rs.getString(2));
            retreiveproject.setProjectStatus(rs.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retreiveproject; //Returning it so you can display it
    }

    public void ProjectList(project P, String client_id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = String.format(
                "select project_id, project_name from project where client_id = '%s' order by project_id",
                client_id.toUpperCase());
        String query2 = "select count(distinct(project_id)) from project";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query2);
            rs.next();
            person_id_list = new String[rs.getInt(1)];
            person_name_list = new String[rs.getInt(1)];
            rs = stmt.executeQuery(query);

            int i = 0;
            while (rs.next()) {
                /*
                 * test = rs.getString(1);
                 * System.out.println(test);
                 */
                person_id_list[i] = rs.getString(1);
                person_name_list[i] = rs.getString(2);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void ClientPriority() {
        Connection c = null;
        String query = "select client_id,count(Project_ID) as Totalprojcount from Project where Status_of_Software='PAID' group by client_id order by Totalprojcount desc;";
        Statement ps = null;
        // String client_id = "CLI001";
        Vector<String> Clientvec = new Vector<String>();
        Vector<Integer> Tprojvec = new Vector<Integer>();
        try {
            String x = "asd"; // just for initialisation
            int y = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            ps = c.createStatement();

            // ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                x = rs.getString("client_id");
                y = rs.getInt("Totalprojcount");
                // for (int i = 0; i < Clientvec.size(); i++) {
                Clientvec.add(x);
                Tprojvec.add(y);
                // }

                // System.out.println(x);

                // System.out.println(y);
            }
            // priority= Clientvec.indexOf(x);
            setPriority(Clientvec.indexOf(x) + 1);
            // System.out.print(Clientvec);
            // System.out.print(Tprojvec);
            // For prioirity thingy
            // update project set priority=? where ID=
            // (1,i)

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Driver {
    public static void main(String[] args) {
        client Cli = new client();
        project pro = new project();
       
        // clire.ClientPriority();
        // Cli.AddProject(pro);
        // Cli.removeProject(pro);
        // Cli.ClientPriority();
        // clire.TotalProjectsCompleted();
        // clire.TotalProjectsPaid();

    }
}