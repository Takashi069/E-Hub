package report;

import employee.employee;

public class employeeReport extends employee{

    /* public String displayReport() {
        return "{" +
                " Employee_ID='" + getID() + "'" +
                ", Employee_join_date='" + getEmployee_join_date() + "'" +
                ", Domain='" + getDomain() + "'" +
                ", Experience='" + getExperience() + "'" +
                "}";
    } */

    String[] displayReport = { getID(), getEmployee_join_date(), getDomain(), Integer.toString(getExperience()) };
    
}