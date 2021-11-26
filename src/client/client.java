package client;

public class client {
    private String clientID;
    private String password;
    private int totalProjectsRequested;
    private int priority;

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String clientID) {
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