package agency.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB {
    // Change DB name, user, password to yours
    private static final String URL = "jdbc:postgresql://localhost:5432/oop";
    private static final String USER = "postgres";
    private static final String PASS = "fsociety";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
