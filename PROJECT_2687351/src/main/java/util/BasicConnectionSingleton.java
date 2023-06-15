package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicConnectionSingleton {
    private static String url =
            "jdbc:mysql://localhost:3306/my_database?serverTimezone=America/Bogota";
    private static String user = "my_database";
    private static String pass = "3124935310Nora";
    private static Connection conn;
    public static Connection getInstance()
            throws SQLException {
        if (conn == null) {
            conn =
                    DriverManager.getConnection(url, user,
                            pass);
        }
        return conn;
    }
} // BasicConnectionSingleton

