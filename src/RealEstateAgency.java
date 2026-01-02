import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.zip.CheckedOutputStream;

public class RealEstateAgency{
    private String name;
    private ArrayList<Property> properties;
    private ArrayList<Apartment> apartments;
    private ArrayList<Agent> agents;
    // constructor
    public RealEstateAgency(String name) {
        this.name = name;
        properties = new ArrayList<>();
        agents = new ArrayList<>();
        apartments = new ArrayList<>();
    }

    // methods
    public void addProperty(Property property) {
        properties.add(property);
    }
    public void addAgent(Agent agent) {
        agents.add(agent);
    }
    public void showProperties() {
        System.out.println("Properties in " + name + ":");
        for (Property p : properties) {
            System.out.println(p.toString());
        }
    }
    public void showApartments() {
        System.out.println("Apartments: ");
        for (Apartment a : apartments) {
            System.out.println(a.toString());
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
            if(p instanceof Apartment) {
                Apartment apt = (Apartment) p;
                if (apt.getprice() <= maxPrice){
                    System.out.println(apt.toString());

                }
            }
        }
        return maxPrice;
    }

    public void sortbyprice() {
        properties.sort((p1, p2) -> {
            if (p1 instanceof Apartment && p2 instanceof Apartment) {
                return Integer.compare(((Apartment) p1).getprice(), ((Apartment) p2).getprice());
            }
            return 0;
        });
    }

    public void showAgents() {
        System.out.println("Agents in " + name + ":");
        for (Agent a : agents) {
            System.out.println(a.toString());
        }
    }
}
