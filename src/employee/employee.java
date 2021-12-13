package employee;

import person.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import gui.secret;


public class employee extends Person {
    private String Employee_ID;
    private String Employee_join_date;
    private String Domain;
    private int Experience;
    private int ProjectsWorked;
    private int ProjectsLed;

    public int getProjectsWorked() {
        return this.ProjectsWorked;
    }

    public void setProjectsWorked(int ProjectsWorked) {
        this.ProjectsWorked = ProjectsWorked;
    }

    public int getProjectsLed() {
        return this.ProjectsLed;
    }

    public void setProjectsLed(int ProjectsLed) {
        this.ProjectsLed = ProjectsLed;
    }

    public String getID() {
        return this.Employee_ID;
    }

    public void setID(String Employee_ID) {
        this.Employee_ID = Employee_ID;
    }

    public String getEmployee_join_date() {
        return this.Employee_join_date;
    }

    public void setEmployee_join_date(String Employee_join_date) {
        this.Employee_join_date = Employee_join_date;
    }

    public String getDomain() {
        return this.Domain;
    }

    public void setDomain(String Domain) {
        this.Domain = Domain;
    }

    public int getExperience() {
        return this.Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
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
        secret s = new secret();
        String ogtype = "employee";
        String queryid = "emp_id";
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
        finalID = "EMP" + countString;
        return finalID;
    }

}