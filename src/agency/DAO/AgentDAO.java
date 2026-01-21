package agency.DAO;
import agency.models.Agent;
import agency.data.PostgresDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {

    public void create(agency.models.Agent a) throws SQLException {
        String sql = "INSERT INTO agent(name, phone, experience) VALUES (?, ?, ?)";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getname());
            ps.setString(2, a.getphone());
            ps.setInt(3, a.getexperience());
            ps.executeUpdate();
        }
    }

    public List<agency.models.Agent> readAll() throws SQLException {
        List<agency.models.Agent> agents = new ArrayList<agency.models.Agent>();
        String sql = "SELECT name, phone, experience FROM agent ORDER BY name";

        try (Connection conn = PostgresDB.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                agents.add(new agency.models.Agent(
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("experience")
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

    public boolean deleteByPhone(String phone) throws SQLException {
        String sql = "DELETE FROM agent WHERE phone = ?";
        try (Connection conn = PostgresDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            return ps.executeUpdate() > 0;
        }
    }
}
