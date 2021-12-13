package report;

import client.client;

public class clientReport extends client {
    private int totalProjectsCompleted;
    private int totalProjectsPaid;

    public int getTotalProjectsCompleted() {
        return this.totalProjectsCompleted;
    }

    public void setTotalProjectsCompleted(int totalProjectsCompleted) {
        this.totalProjectsCompleted = totalProjectsCompleted;
    }

    public int getTotalProjectsPaid() {
        return this.totalProjectsPaid;
    }

    public void setTotalProjectsPaid(int totalProjectsPaid) {
        this.totalProjectsPaid = totalProjectsPaid;
    }

    /* public void TotalProjectsCompleted() {
        Connection c = null;
        String query = "select count(Project_ID) as Totalprojcount from Project where Client_ID = ? and Status_of_Software='COMPLETED'";
        // The following lines of code are temporary:
    
        String client_id = "CLI001";
        try {
            int x = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                x = rs.getInt("Totalprojcount");
            }
            rs.close();
            System.out.println(x + " is the count");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

    /* public void TotalProjectsPaid() {
        Connection c = null;
        String query = "select count(Project_ID) as Totalprojcount from Project where Client_ID = ? and Status_of_Software='PAID'";
        // The following lines of code are temporary:
    
        String client_id = "CLI001";
        try {
            int x = 0;
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(s.url, s.dbUser, s.dbPass);
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, client_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                x = rs.getInt("Totalprojcount");
            }
            rs.close();
            System.out.println(x + " is the count");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

    /* public String displayReport() { //right now it does nothing
        return "{" +
                " clientID='" + getID() + "'" +
                ", totalProjectsRequested='" + getTotalProjectsRequested() + "'" +
                ", priority='" + getPriority() + "'" +
                " totalProjectsCompleted='" + getTotalProjectsCompleted() + "'" +
                ", totalProjectsPaid='" + getTotalProjectsPaid() + "'" +
                "}";
    } */

    public String[] setDisplayReport() {
        
        String[] displayReport = { getID(), getCompany(), Integer.toString(getPriority()),
                Integer.toString(getTotal_Orders()) };
        return displayReport;
    }
}
