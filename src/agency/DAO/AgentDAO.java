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
        String sql = "SELECT * FROM agent";

        try (Connection conn = PostgresDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                int exp = rs.getInt("experience");

                agents.add(new Agent(name, phone, exp));

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

    public boolean deleteByName(String name) throws SQLException {
        String sql = "DELETE FROM agent WHERE name = ?";
        try (Connection conn = PostgresDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            return ps.executeUpdate() > 0;
        }
    }
}
