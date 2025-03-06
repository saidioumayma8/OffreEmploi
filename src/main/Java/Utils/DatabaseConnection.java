package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de données MySQL
    private static final String URL = "jdbc:mysql://127.0.0.1:3305/OffreEmploi";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        try {
            // Enregistrer le driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful!"); // Message de confirmation

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
