package agency;
import agency.algorithms.Apartmentsorter;
import agency.DAO.AgentDAO;
import agency.DAO.ApartmentDAO;
import agency.models.Agent;
import agency.models.Apartment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printAgents(List<Agent> agents) {
        if (agents == null || agents.isEmpty()) {
            System.out.println("No agents found.");
            return;
        }
        for (Agent a : agents) System.out.println(a);
    }

    private static void printApartments(List<Apartment> apartments) {
        if (apartments == null || apartments.isEmpty()) {
            System.out.println("No apartments found.");
            return;
        }
        for (Apartment a : apartments) System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AgentDAO agentDAO = new AgentDAO();
        ApartmentDAO apartmentDAO = new ApartmentDAO();

        int choice;
        do {
            System.out.println("\n=== REAL ESTATE CRUD MENU ===");
            System.out.println("Agents:");
            System.out.println("  1) Show all agents (READ)");
            System.out.println("  2) Add agent (CREATE)");
            System.out.println("  3) Update agent experience (UPDATE)");
            System.out.println("  4) Delete agent by name (DELETE)");
            System.out.println("Apartments:");
            System.out.println("  5) Show all apartments (READ)");
            System.out.println("  6) Add apartment (CREATE)");
            System.out.println("  7) Update apartment price (UPDATE)");
            System.out.println("  8) Delete apartment (DELETE)");
            System.out.println("Extra:");
            System.out.println("  9) Filter apartments by max price (READ)");
            System.out.println(" 10) Show apartments sorted by price (READ)");
            System.out.println(" 11) Add new column to Agent");
            System.out.println(" 12) Update city by agent name");
            System.out.println(" 13) Sort by price of apartments");
            System.out.println("  0) Exit");
            System.out.print("Choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.nextLine();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        printAgents(agentDAO.readAll());
                        break;

                    case 2: {
                        System.out.print("Agent name: ");
                        String name = sc.nextLine();

                        System.out.print("Phone (unique): ");
                        String phone = sc.nextLine();

                        System.out.print("Experience (years): ");
                        int exp = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Status (true/false): ");
                        boolean status = sc.nextBoolean();
                        sc.nextLine();

                        System.out.print("feature1 (int): ");
                        int feature1 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("city: ");
                        String city = sc.nextLine();

                        agentDAO.create(new Agent(name, phone, exp, status, feature1, city));
                        System.out.println("Agent added.");
                        break;
                    }

                    case 3: {
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("New experience: ");
                        int exp = sc.nextInt();
                        sc.nextLine();

                        boolean ok = agentDAO.updateExperience(phone, exp);
                        System.out.println(ok ? "Agent updated." : "Agent not found.");
                        break;
                    }

                    case 4: {
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        boolean ok = agentDAO.deleteByName(name);
                        System.out.println(ok ? "Agent deleted." : "Agent not found.");
                        break;
                    }

                    case 5:
                        printApartments(apartmentDAO.readAll());
                        break;

                    case 6: {
                        System.out.print("Apartment name: ");
                        String name = sc.nextLine();

                        System.out.print("Address (unique): ");
                        String address = sc.nextLine();

                        System.out.print("Price: ");
                        int price = sc.nextInt();

                        System.out.print("Area: ");
                        double area = sc.nextDouble();

                        System.out.print("Floor: ");
                        int floor = sc.nextInt();

                        System.out.print("Rooms: ");
                        int rooms = sc.nextInt();
                        sc.nextLine();

                        apartmentDAO.create(new Apartment(name, address, price, area, floor, rooms));
                        System.out.println("Apartment added.");
                        break;
                    }

                    case 7: {
                        System.out.print("Address: ");
                        String address = sc.nextLine();

                        System.out.print("New price: ");
                        int newPrice = sc.nextInt();
                        sc.nextLine();

                        boolean ok = apartmentDAO.updatePrice(address, newPrice);
                        System.out.println(ok ? "Apartment updated." : "Apartment not found.");
                        break;
                    }

                    case 8: {
                        System.out.print("Address: ");
                        String address = sc.nextLine();

                        boolean ok = apartmentDAO.deleteByAddress(address);
                        System.out.println(ok ? "Apartment deleted." : "Apartment not found.");
                        break;
                    }

                    case 9: {
                        System.out.print("Max price: ");
                        int maxPrice = sc.nextInt();
                        sc.nextLine();

                        printApartments(apartmentDAO.filterByMaxPrice(maxPrice));
                        break;
                    }

                    case 10:
                        printApartments(apartmentDAO.readAllSortedByPrice());
                        break;

                    case 11: {
                        System.out.print("New column name: ");
                        String colName = sc.nextLine();

                        System.out.print("Type of data (TEXT/INT/BOOLEAN/DOUBLE): ");
                        String type = sc.next();
                        sc.nextLine();

                        agentDAO.addColumn(colName, type);
                        System.out.println("Column added successfully");
                        break;
                    }

                    case 12: {
                        System.out.print("New city name: ");
                        String city = sc.nextLine();

                        System.out.print("Name of agent: ");
                        String agentName = sc.nextLine();

                        boolean ok = agentDAO.updateCityByName(agentName, city);
                        System.out.println(ok ? "Updated." : "Agent not found.");
                        break;
                    }
                    case 13: {
                        System.out.println("Sorting...");
                        List<Apartment> apts = apartmentDAO.readAll();
                        List<Apartment> sorted;
                        sorted = Apartmentsorter.bubbleSort(apts);
                        printApartments(sorted);
                        break;
                    }

                    case 0:
                        System.out.println("Bye.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (SQLException e) {
                System.out.println("DB error: " + e.getMessage());
            }
        } while (choice != 0);

        sc.close();
    }
}
