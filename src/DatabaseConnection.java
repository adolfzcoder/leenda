import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlserver://localhost;databaseName=car_rental;integratedSecurity=true;";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }
}
