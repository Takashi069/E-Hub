package Project;

public class project {

    private String ProjectID;
    private String ProjectName;
    private String ProjectType;
    private String ProjectDeadline;
    private String[] ProjectMembers;
    private String ProjectHead;
    private String ProjectStatus;
    private String ClientID;

    public String getProjectID() {
        return this.ProjectID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public String getProjectName() {
        return this.ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getProjectType() {
        return this.ProjectType;
    }

    public void setProjectType(String ProjectType) {
        this.ProjectType = ProjectType;
    }

    public String getProjectDeadline() {
        return this.ProjectDeadline;
    }

    public void setProjectDeadline(String ProjectDeadline) {
        this.ProjectDeadline = ProjectDeadline;
    }

    public String[] getProjectMembers() {
        return this.ProjectMembers;
    }

    public void setProjectMembers(String[] ProjectMembers) {
        this.ProjectMembers = ProjectMembers;
    }

    public String getProjectHead() {
        return this.ProjectHead;
    }

    public void setProjectHead(String ProjectHead) {
        this.ProjectHead = ProjectHead;
    }

    public String getProjectStatus() {
        return this.ProjectStatus;
    }

    public void setProjectStatus(String ProjectStatus) {
        this.ProjectStatus = ProjectStatus;
    }

    public String getClientID() {
        return this.ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

}

class Project_report extends project {

    private String Date_of_Commencement;

    public String getDate_of_Commencement() {
        return this.Date_of_Commencement;
    }

    public void setDate_of_Commencement(String Date_of_Commencement) {
        this.Date_of_Commencement = Date_of_Commencement;
    }

    public String displayReport() {
        return "{" +
                " ProjectID='" + getProjectID() + "'" +
                ", ProjectName='" + getProjectName() + "'" +
                ", ProjectType='" + getProjectType() + "'" +
                ", ProjectDeadline='" + getProjectDeadline() + "'" +
                ", ProjectMembers='" + getProjectMembers() + "'" +
                ", ProjectHead='" + getProjectHead() + "'" +
                ", ProjectStatus='" + getProjectStatus() + "'" +
                ", ClientID='" + getClientID() + "'" +
                " Date_of_Commencement='" + getDate_of_Commencement() + "'" +
                "}";
    }

}
