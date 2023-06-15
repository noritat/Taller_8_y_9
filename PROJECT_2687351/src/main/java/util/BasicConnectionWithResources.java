package util;

import java.sql.*;

public class BasicConnectionWithResources {

    public static void main(String[] args)
    {
        String url =
                "jdbc:mysql://localhost:3306/my_database?serverTimezone=America/Bogota";
        String username = "my_database";
        String password = "3124935310Nora";
        String sql = "SELECT * FROM my_database.users_tbl";
        try (Connection conn = DriverManager.getConnection(url,username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                System.out.print(rs.getString("user_firstname"));
                System.out.print(" | ");

                System.out.println(rs.getString("user_lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } // end try-catch
    } // main
} // BasicConnectionWithResources
