import java.util.ArrayList;
import java.util.Comparator;

public class RealEstateAgency extends Property{
    private String name_agency;
    private ArrayList<Property> properties;
    private ArrayList<Agent> agents;
    // constructor
    public RealEstateAgency(String name, String address, int price, double area, int floor, String name_agency) {
        super(name, address, price, area, floor);
        this.name_agency = name_agency;
        properties = new ArrayList<>();
        agents = new ArrayList<>();
    }

    // methods
    public void addProperty(Property property) {
        properties.add(property);
    }
    public void addAgency(Agent agent) {
        agents.add(agent);
    }
    public void showProperties() {
        System.out.println("Properties in " + name_agency + ":");
        for (Property p : properties) {
            System.out.println(p.toString());
        }
    }

    public ArrayList<Agent> getAgents() {return agents;}

    public Property findByAddress(String address) {
        for (Property p : properties) {
            if (p.getaddress().equals(address)) {
                return p;
            }
        }
        return null;
    }

    public double filterByPrice(double maxPrice) {
        for (Property p : properties) {
            if(p.getprice() >= maxPrice) {
                maxPrice = p.getprice();
            }
        }
        return maxPrice;
    }

    public void sortbyprice() {
        properties.sort(Comparator.comparingInt(Property::getprice));
    }

    public void showAgents() {
        System.out.println("Agents in " + name_agency + ":");
        for (Agent a : agents) {
            System.out.println(a.toString());
        }
    }
}
