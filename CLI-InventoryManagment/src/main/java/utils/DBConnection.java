package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//database connection set up
public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/storeInventory";
    private static final String USER = "postgres";
    private static final String PASSWORD = "cl1We0-&!am";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
