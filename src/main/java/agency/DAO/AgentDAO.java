package agency.DAO;

import agency.data.PostgresDB;
import agency.models.Agent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {

    public void create(Agent a) throws SQLException {
        String sql = "INSERT INTO agent(name, phone, experience, status, feature1, city) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getname());
            ps.setString(2, a.getphone());
            ps.setInt(3, a.getexperience());
            ps.setBoolean(4, a.getstatus());
            ps.setInt(5, a.getfeature1());
            ps.setString(6, a.getcity());

            ps.executeUpdate();
        }
    }

    public List<Agent> readAll() throws SQLException {
        List<Agent> agents = new ArrayList<Agent>();
        String sql = "SELECT name, phone, experience, status, feature1, city FROM agent";

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                agents.add(new Agent(
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("experience"),
                        rs.getBoolean("status"),
                        rs.getInt("feature1"),
                        rs.getString("city")
                ));
            }
        }
        return agents;
    }

    public boolean updateExperience(String phone, int newExperience) throws SQLException {
        String sql = "UPDATE agent SET experience = ? WHERE phone = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newExperience);
            ps.setString(2, phone);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateCityByName(String name, String newCity) throws SQLException {
        String sql = "UPDATE agent SET city = ? WHERE name = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newCity);
            ps.setString(2, name);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteByName(String name) throws SQLException {
        String sql = "DELETE FROM agent WHERE name = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            return ps.executeUpdate() > 0;
        }
    }

    // safer ALTER: validate identifier + whitelist types
    public void addColumn(String columnName, String typeData) throws SQLException {
        if (columnName == null || !columnName.matches("[a-z_][a-z0-9_]*")) {
            throw new IllegalArgumentException("Invalid column name");
        }

        String type = typeData.toUpperCase();
        if (!(type.equals("TEXT") || type.equals("INT") || type.equals("INTEGER")
                || type.equals("BOOLEAN") || type.equals("DOUBLE") || type.equals("DOUBLE PRECISION"))) {
            throw new IllegalArgumentException("Invalid type");
        }

        String sql = "ALTER TABLE agent ADD COLUMN IF NOT EXISTS " + columnName + " " + type;

        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }
}
