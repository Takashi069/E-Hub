package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import person.Person;

public class client extends Person {
    public client(){
        super();
    }
    private String clientID;
    private String password;
    private int totalProjectsRequested;
    private int priority;

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
}

class Client_Report extends client {
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

    public String displayReport() {
        return "{" +
        " clientID='" + getID() + "'" +
            ", totalProjectsRequested='" + getTotalProjectsRequested() + "'" +
            ", priority='" + getPriority() + "'" +
            " totalProjectsCompleted='" + getTotalProjectsCompleted() + "'" +
            ", totalProjectsPaid='" + getTotalProjectsPaid() + "'" +
            "}";
    }

}