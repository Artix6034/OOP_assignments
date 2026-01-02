public class Apartment extends Property{
    private int price;
    private int floor;
    private double area;
    private int rooms;
    public Apartment(String name, String address, int price, double area, int floor, int rooms) {
        super(name ,address);
        this.price = price;
        this.floor = floor;
        this.area = area;
        this.rooms = rooms;
    }
    // getters
    public int getprice() {return price;}
    public int getfloor() {return floor;}
    public double getarea() {return area;}
    public int getrooms() {return rooms;}
    //setters
    public void setprice(int price) {this.price = price;}
    public void setfloor(int floor) {this.floor = floor;}
    public void setarea(double area) {this.area = area;}
    public void setrooms(int rooms) {this.rooms = rooms;}

    @Override
    public String toString() {
        return super.toString() + "Price: " + price + "at floor: " +  floor + "has area: " + area + "has:" + rooms + "rooms";
    }
}
