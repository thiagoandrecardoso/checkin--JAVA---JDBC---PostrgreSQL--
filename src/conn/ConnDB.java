package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ConnDB {
    private ConnDB() {
    }

    private static final String URL = "jdbc:postgresql://134.209.243.185:5432/vavatur";
    private static final String user = "vavatur";
    private static final String password = "gGgLqu";

    private static Connection connection = null;

    public static Connection getInstance() throws SQLDataException {
        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connect to the PostgreSQL.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
