package agency.DTO;

public class ApartmentDTO {
    private String name;
    private String address;
    private int price;
    private double area;
    private int floor;
    private int rooms;

    public ApartmentDTO() {}

    public ApartmentDTO(String name, String address, int price, double area, int floor, int rooms) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getPrice() { return price; }
    public double getArea() { return area; }
    public int getFloor() { return floor; }
    public int getRooms() { return rooms; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPrice(int price) { this.price = price; }
    public void setArea(double area) { this.area = area; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setRooms(int rooms) { this.rooms = rooms; }
}
