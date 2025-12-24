public class Property {
    private String name;
    private String address;
    private int price;
    private double area;
    private int floor;
    private Agent agent;

    // below is constructor
    public Property(String name, String address, int price, double area, int floor) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
        this.floor = floor;
    }

    // getters
    public String getname() {
        return this.name;
    }
    public String getaddress() {
        return this.address;
    }
    public int getprice() {
        return this.price;
    }
    public double getarea() {
        return this.area;
    }
    public Agent getAgent() { return this.agent;}
    // setters
    public void setname(String name) {
        this.name = name;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public void setprice(int price) {
        this.price = price;
    }
    public void setarea(double area) {
        this.area = area;
    }
    public void setagent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return name + " is at "+ address + " costs "+ price + " and it's area "+ area;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property p = (Property) o;
        return address.equals(p.address);
    }
    @Override
    public int hashCode() {
        return address.hashCode();
    }
}


