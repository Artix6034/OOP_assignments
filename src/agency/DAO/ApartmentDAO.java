package agency.DAO;
import agency.models.Apartment;
import agency.data.PostgresDB;
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
        return readList(sql, null);
    }

    public List<agency.models.Apartment> readAllSortedByPrice() throws SQLException {
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment ORDER BY price";
        return readList(sql, null);
    }

    public List<agency.models.Apartment> filterByMaxPrice(int maxPrice) throws SQLException {
        String sql = "SELECT name, address, price, floor, area, rooms FROM apartment WHERE price <= ? ORDER BY price";
        return readList(sql, ps -> ps.setInt(1, maxPrice));
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

    // ---------- helper ----------
    private interface Binder {
        void bind(PreparedStatement ps) throws SQLException;
    }

    private List<agency.models.Apartment> readList(String sql, Binder binder) throws SQLException {
        List<agency.models.Apartment> apartments = new ArrayList<>();
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (binder != null) binder.bind(ps);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    apartments.add(new agency.models.Apartment(
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
}

