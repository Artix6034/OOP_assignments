package agency.models;
public class Agent {
    private String name;
    private String phone;
    private int experience;
    private boolean status;
    private int feature1;
    private String city;

    // constructor
    public Agent (String name, String phone, int experience, boolean status, int feature1, String city) {
        this.name = name;
        this.phone = phone;
        this.experience = experience;
        this.status = status;
        this.feature1 = feature1;
        this.city = city;

    }

    // getters
    public String getname() {
        return name;
    }
    public String getphone(){
        return phone;
    }
    public int getexperience() {
        return experience;
    }
    public boolean getstatus(){return status;}
    public int getfeature1() {return feature1;}
    public String getcity() {return city;}
    // setters
    public void setname(String name) {
        this.name = name;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    public void setexperience(int experience) {this.experience = experience;}
    public void setstatus(boolean status) {this.status = status;}
    public void setfeature1(int feature1) {this.feature1 = feature1;}
    public void setcity (String city) {this.city = city;}
    @Override
    public String toString() {
        return name + "'s phone: " + phone + ", he has " + experience + " years of experience";
    }
}
