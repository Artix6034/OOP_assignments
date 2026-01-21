package agency.models;
public class Agent {
    private String name;
    private String phone;
    private int experience;

    // constructor
    public Agent (String name, String phone, int experience) {
        this.name = name;
        this.phone = phone;
        this.experience = experience;
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
    // setters
    public void setname(String name) {
        this.name = name;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    public void setexperience(int experience) {
        this.experience = experience;
    }
    @Override
    public String toString() {
        return name + "'s phone: " + phone + ", he has " + experience + " years of experience";
    }
}
