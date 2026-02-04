package agency.services;

import agency.DAO.AgentDAO;
import agency.DAO.ApartmentDAO;
import agency.models.Agent;
import agency.models.Apartment;

import java.sql.SQLException;
import java.util.List;

public class RealEstateAgency {

    private final AgentDAO agentDAO;
    private final ApartmentDAO apartmentDAO;

    public RealEstateAgency(AgentDAO agentDAO, ApartmentDAO apartmentDAO) {
        this.agentDAO = agentDAO;
        this.apartmentDAO = apartmentDAO;
    }

    // ---------------- Agents (CRUD) ----------------
    public void addAgent(Agent a) throws SQLException {
        if (a == null) throw new IllegalArgumentException("Agent is null");
        if (a.getphone() == null || a.getphone().trim().isEmpty())
            throw new IllegalArgumentException("Phone is required");
        if (a.getexperience() < 0)
            throw new IllegalArgumentException("Experience must be >= 0");

        agentDAO.create(a);
    }

    public List<Agent> getAllAgents() throws SQLException {
        return agentDAO.readAll();
    }

    public boolean updateAgentExperience(String phone, int newExperience) throws SQLException {
        if (phone == null || phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone is required");
        if (newExperience < 0)
            throw new IllegalArgumentException("Experience must be >= 0");

        return agentDAO.updateExperience(phone, newExperience);
    }

    public boolean deleteAgentByName(String name) throws SQLException {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name is required");
        return agentDAO.deleteByName(name);
    }

    // ---------------- Apartments (CRUD) ----------------
    public void addApartment(Apartment a) throws SQLException {
        if (a == null) throw new IllegalArgumentException("Apartment is null");
        if (a.getaddress() == null || a.getaddress().trim().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if (a.getprice() < 0)
            throw new IllegalArgumentException("Price must be >= 0");
        if (a.getarea() <= 0)
            throw new IllegalArgumentException("Area must be > 0");
        if (a.getrooms() <= 0)
            throw new IllegalArgumentException("Rooms must be > 0");

        apartmentDAO.create(a);
    }

    public List<Apartment> getAllApartments() throws SQLException {
        return apartmentDAO.readAll();
    }

    public List<Apartment> getApartmentsSortedByPrice() throws SQLException {
        return apartmentDAO.readAllSortedByPrice();
    }

    public List<Apartment> filterApartmentsByMaxPrice(int maxPrice) throws SQLException {
        if (maxPrice < 0) throw new IllegalArgumentException("Max price must be >= 0");
        return apartmentDAO.filterByMaxPrice(maxPrice);
    }

    public boolean updateApartmentPrice(String address, int newPrice) throws SQLException {
        if (address == null || address.trim().isEmpty())
            throw new IllegalArgumentException("Address is required");
        if (newPrice < 0)
            throw new IllegalArgumentException("Price must be >= 0");

        return apartmentDAO.updatePrice(address, newPrice);
    }

    public boolean deleteApartmentByAddress(String address) throws SQLException {
        if (address == null || address.trim().isEmpty())
            throw new IllegalArgumentException("Address is required");
        return apartmentDAO.deleteByAddress(address);
    }
}
