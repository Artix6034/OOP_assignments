import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.print("Agency name: ");
        String name_agency = sc.nextLine();

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
        RealEstateAgency agency = new RealEstateAgency(name, address, price, area, floor, name_agency);


        do {
            System.out.println("Choose the option");
            System.out.println("1. Show properties");
            System.out.println("2. Add agents");
            System.out.println("3. Search by address");
            System.out.println("4. Filter by price");
            System.out.println("5. Sort by price");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    agency.showProperties();
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name_agent = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Expreience: ");
                    int experience = sc.nextInt();

                    Agent a = new Agent(name_agent, phone, experience);
                    agency.addAgency(a);
                    break;
                case 3:
                    System.out.print("Enter address: ");
                    String addresssearch = sc.nextLine();
                    System.out.println(agency.findByAddress(addresssearch));
                    break;
                case 4:
                    System.out.println("Max price: ");
                    int maxprice = sc.nextInt();
                    agency.filterByPrice(maxprice);
                    break;
                case 5:
                    agency.sortbyprice();
                    agency.showProperties();
                    break;
            }
        } while (choice != 0);
    }
}