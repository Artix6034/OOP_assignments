public class Property {
    private String name;
    private String address;
    private int price;
    private double area;
    public Property(String name, String address, int price, double area) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
    }
    public String printname() {
        System.out.println("Name of the property: ");
        return name;
    }
    public String printaddress() {
        System.out.println("Address of the property: ");
        return address;
    }
    public int printprice() {
        System.out.println("Price of the property: ");
        return price;
    }
    public double printarea() {
        System.out.println("Area of the property: ");
        return area
    }
}
