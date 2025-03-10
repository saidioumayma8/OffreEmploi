package User.DAO;

import User.Model.User;
import Utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection;

    public RegisterDAO() throws SQLException {
        // Establish connection to the database
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean registerUser(User user) {
        // SQL query to insert a new user into the database
        String query = "INSERT INTO users (nom, email, password, user_type) VALUES (?, ?, ?, ?)";

        // Prepare the statement and execute the update
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword()); // In real-world, you should hash the password before saving it
            stmt.setString(4, user.getRole());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if the user was inserted
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if insertion failed
    }
}
