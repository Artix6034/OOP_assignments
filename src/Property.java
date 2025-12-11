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

}
