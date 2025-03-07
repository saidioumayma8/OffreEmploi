<<<<<<<< HEAD:src/main/Java/Candidat/Utils/DatabaseConnection.java
package Candidat.Utils;
========
package Utils;
>>>>>>>> bdd57ef34d570b49a22bfa4043ca14a4e9259264:src/main/Java/Utils/DatabaseConnection.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/OffreEmploi";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful!");

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found!");
            throw new SQLException("Database driver not found", e);
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
            throw e;
        }
    }
}
