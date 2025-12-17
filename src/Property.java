public class Property {
    private String name;
    private String address;
    private int price;
    private double area;

    // below is constructor
    public Property(String name, String address, int price, double area) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
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
    @Override
    public String toString() {
        return name + " is at "+ address + " costs "+ price + " and it's area "+ area;
    }
}


