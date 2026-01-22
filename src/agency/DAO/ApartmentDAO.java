package agency.DAO;
import agency.models.Apartment;
import agency.data.PostgresDB;

import javax.management.openmbean.CompositeDataSupport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

    public void create(agency.models.Apartment a) throws SQLException {
        String sql = "INSERT INTO apartment(name, address, price, floor, area, rooms) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getname());
            ps.setString(2, a.getaddress());
            ps.setInt(3, a.getprice());
            ps.setInt(4, a.getfloor());
            ps.setDouble(5, a.getarea());
            ps.setInt(6, a.getrooms());
            ps.executeUpdate();
        }
    }

    public List<agency.models.Apartment> readAll() throws SQLException {
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment";
        List<agency.models.Apartment> apartments = new ArrayList<Apartment>();
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                int price = rs.getInt("price");
                double area = rs.getDouble("area");
                int floor = rs.getInt("floor");
                int rooms = rs.getInt("rooms");
                apartments.add(new Apartment(name, address, price, area, floor, rooms));
            }
        }
        return apartments;
    }

    public List<agency.models.Apartment> readAllSortedByPrice() throws SQLException {
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment ORDER BY price";
        List<agency.models.Apartment> apartments = new ArrayList<Apartment>();
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                int price = rs.getInt("price");
                double area = rs.getDouble("area");
                int floor = rs.getInt("floor");
                int rooms = rs.getInt("rooms");
                apartments.add(new Apartment(name, address, price, area, floor, rooms));
            }
        }
        return apartments;
    }

    public List<agency.models.Apartment> filterByMaxPrice(int maxPrice) throws SQLException {
        List<agency.models.Apartment> apartments = new ArrayList<>();
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment WHERE price <= ? ORDER BY price";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maxPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    int price = rs.getInt("price");
                    double area = rs.getDouble("area");
                    int floor = rs.getInt("floor");
                    int rooms = rs.getInt("rooms");
                    apartments.add(new Apartment(name, address, price, area, floor, rooms));
                }
            }
        }
        return apartments;
    }

    public boolean updatePrice(String address, int newPrice) throws SQLException {
        String sql = "UPDATE apartment SET price = ? WHERE address = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newPrice);
            ps.setString(2, address);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteByAddress(String address) throws SQLException {
        String sql = "DELETE FROM apartment WHERE address = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, address);
            return ps.executeUpdate() > 0;
        }
    }
}


