import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.print("Agency name: ");
        String name_agency = sc.nextLine();
        RealEstateAgency agency = new RealEstateAgency(name_agency);


        do {
            System.out.println("Choose the option");
            System.out.println("1. Show properties");
            System.out.println("2. Add property");
            System.out.println("3. Add apartment");
            System.out.println("4. Add agents");
            System.out.println("5. Show agents");
            System.out.println("6. Search by address");
            System.out.println("7. Filter by price");
            System.out.println("8. Sort by price:");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    agency.showProperties();
                    break;
                case 2:
                    System.out.print("Property name: ");
                    String propName = sc.nextLine();
                    System.out.print("Address: ");
                    String propAddress = sc.nextLine();
                    Property property = new Property(propName, propAddress);
                    agency.addProperty(property);
                    break;
                case 3:
                    System.out.print("Apartment name: ");
                    String name = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("Price: ");
                    int price = sc.nextInt();
                    System.out.print("Area: ");
                    double area = sc.nextDouble();
                    System.out.print("Floor: ");
                    int floor = sc.nextInt();
                    System.out.print("Rooms: ");
                    int rooms = sc.nextInt();
                    Apartment apartment = new Apartment(name, address, price, area, floor, rooms);
                    agency.addProperty(apartment);
                    break;
                case 4:
                    System.out.print("Agent name: ");
                    String name_agent = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Experience (years): ");
                    int experience = sc.nextInt();
                    Agent agent = new Agent(name_agent, phone, experience);
                    agency.addAgent(agent);
                    break;
                case 5:
                    agency.showAgents();
                    break;
                case 6:
                    System.out.print("Enter address: ");
                    String searchAddress = sc.nextLine();
                    Property found = agency.findByAddress(searchAddress);
                    if (found != null) {
                        System.out.println("Found: " + found.toString());
                    } else {
                        System.out.println("Property not found");
                    }
                    break;
                case 7:
                    System.out.print("Max price: ");
                    int maxPrice = sc.nextInt();
                    agency.filterByPrice(maxPrice);
                    break;
                case 8:
                    agency.sortbyprice();
                    System.out.println("Apartments sorted by price!");
                    agency.showApartments();
                    break;
            }
        } while (choice != 0);
    }
}