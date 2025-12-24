import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RealEstateAgency agency = new RealEstateAgency("BI Group");
        int choice;
        do {
            System.out.println("Choose the option");
            System.out.println("1. Add property");
            System.out.println("2. Show properties");
            System.out.println("3. Add agents");
            System.out.println("4. Search by address");
            System.out.println("5. Filter by price");
            System.out.println("6. Sort by price");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("Price: ");
                    int price = sc.nextInt();

                    System.out.println("Area: ");
                    double area = sc.nextDouble();

                    System.out.print("Floor: ");
                    int floor = sc.nextInt();

                    Property p = new Property(name, address, price, area, floor);
                    agency.addProperty(p);

                    if (agency.getAgents().isEmpty()) {
                        System.out.println("There is no agents, you need to add one");
                        break;
                    } else  {
                        System.out.println("Choose agent: ");
                        agency.showAgents();
                        int index = sc.nextInt();
                        sc.nextLine();
                        p.setagent(agency.getAgents().get(index));
                    }
                    break;
                case 2:
                    agency.showProperties();
                    break;
                case 3:
                    System.out.print("Name: ");
                    String name_agent = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Expreience: ");
                    int experience = sc.nextInt();

                    Agent a = new Agent(name_agent, phone, experience);
                    agency.addAgency(a);
                    break;
                case 4:
                    System.out.print("Enter address: ");
                    String addresssearch = sc.nextLine();
                    System.out.println(agency.findByAddress(addresssearch));
                    break;
                case 5:
                    System.out.println("Max price: ");
                    int maxprice = sc.nextInt();
                    agency.filterByPrice(maxprice);
                    break;
                case 6:
                    agency.sortbyprice();
                    agency.showProperties();
                    break;
            }
        } while (choice != 0);
    }
}