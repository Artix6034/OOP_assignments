package agency.DAO;

import agency.data.PostgresDB;
import agency.models.Apartment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

    public void create(Apartment a) throws SQLException {
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

    public List<Apartment> readAll() throws SQLException {
        List<Apartment> apartments = new ArrayList<Apartment>();
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                apartments.add(new Apartment(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("price"),
                        rs.getDouble("area"),
                        rs.getInt("floor"),
                        rs.getInt("rooms")
                ));
            }
        }
        return apartments;
    }

    public List<Apartment> readAllSortedByPrice() throws SQLException {
        List<Apartment> apartments = new ArrayList<Apartment>();
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment ORDER BY price";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                apartments.add(new Apartment(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getInt("price"),
                        rs.getDouble("area"),
                        rs.getInt("floor"),
                        rs.getInt("rooms")
                ));
            }
        }
        return apartments;
    }

    public List<Apartment> filterByMaxPrice(int maxPrice) throws SQLException {
        List<Apartment> apartments = new ArrayList<Apartment>(); // (no diamond)
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment WHERE price <= ? ORDER BY price";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maxPrice);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    apartments.add(new Apartment(
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getInt("price"),
                            rs.getDouble("area"),
                            rs.getInt("floor"),
                            rs.getInt("rooms")
                    ));
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
