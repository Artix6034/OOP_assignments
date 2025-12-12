public class Agency {
    public String name;
    public String phone;
    private int experience;

    // constructor
    public Agency (String name, String phone, int experience) {
        this.name = name;
        this.phone = phone;
        this.experience = experience;
    }

    // printing values
    public String printname() {
        System.out.println("Agent name: ");
        return name;
    }
    public String printphone(){
        System.out.println("Your agent's phone number: ");
        return phone;
    }
    public int printexperience() {
        System.out.println("Your agent's experience: ");
        return experience;
    }
    // Setting values
    public void setname(String name) {
        this.name = name;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    public void setexperience(int experience) {
        this.experience = experience;
    }
}
