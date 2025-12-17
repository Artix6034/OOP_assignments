public class Main {
    public static void main(String[] args) {
        Property property1 = new Property("Expo-Plaza", "Uly-dala", 17000000, 60);
        Agent agent1 = new Agent("Agent1", "87777775250", 20);
        Property property2 = new Property("Arman-Qala", "Uly-Dala", 29000000, 60.5);
        Agent agent2 = new Agent("Agent2", "87112113456", 5);
        RealEstateAgency agency = new RealEstateAgency("Dream Homes");
        // add properties and agents
        agency.addProperty(property1);
        agency.addProperty(property2);
        agency.addAgency(agent1);
        agency.addAgency(agent2);
        // Output to console
        agency.showAgents();
        agency.showProperties();

    }
}