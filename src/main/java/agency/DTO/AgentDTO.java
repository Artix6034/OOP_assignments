package agency.DTO;

public class AgentDTO {
    private String name;
    private String phone;
    private int experience;
    private boolean status;
    private int feature1;
    private String city;

    public AgentDTO() {}

    public AgentDTO(String name, String phone, int experience, boolean status, int feature1, String city) {
        this.name = name;
        this.phone = phone;
        this.experience = experience;
        this.status = status;
        this.feature1 = feature1;
        this.city = city;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getExperience() { return experience; }
    public boolean isStatus() { return status; }
    public int getFeature1() { return feature1; }
    public String getCity() { return city; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setStatus(boolean status) { this.status = status; }
    public void setFeature1(int feature1) { this.feature1 = feature1; }
    public void setCity(String city) { this.city = city; }
}
