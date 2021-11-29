package person;
public abstract class Person {
    private String name;
    private String DOB;
    private String[] Address;
    private int PINCODE;
    private String Nationality;
    private String PhoneNumber;

    //Why does this work ?
    public Person(){

        name = "John Doe";
        DOB = "01/01/1950";
        Address = new String[]{"StreetName", "Locality","District","State"};
        PINCODE = 000000;
        Nationality = "Indian";
        PhoneNumber = "+910000000000";
    }

    public abstract String getID();
    public abstract void setID(String ID);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    /*
    getAddress is a string array whose elements are as follows:
    Address[0] = "Street Name"
    Address[1] = "Locality"
    Address[2] = "District"
    Address[3] = "State"
    */
    public String[] getAddress() {
        return Address;
    }

    public void setAddress(String[] Address) {
        this.Address = Address;
    }

    public int getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(int PINCODE) {
        this.PINCODE = PINCODE;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

}