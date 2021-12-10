package report;
import Project.project;

public class projectReport extends project {
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