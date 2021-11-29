package employee;

import person.Person;

public class employee extends Person {
    private String Employee_ID;
    private String Employee_join_date;
    private String Domain;
    private int Experience;

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

}