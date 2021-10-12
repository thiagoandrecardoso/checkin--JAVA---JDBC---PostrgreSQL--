package conn;

import java.sql.*;

public class ConnDB {
    private static final String URL = "jdbc:postgresql://134.209.243.185:5432/vavatur";
    private static final String user = "vavatur";
    private static final String password = "gGgLqu";
    private static Connection connection = null;

    private ConnDB() {
    }

    public static Connection getInstance() throws SQLDataException {
        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connect to the PostgreSQL.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void CloseConn(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CLosePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CloseResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
