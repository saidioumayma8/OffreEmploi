package Recruteur.DAO;

import Recruteur.Model.OffreEmploi;
import java.sql.*;

public class OffreEmploiDAO {
    private Connection connection;

    public OffreEmploiDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createOffre(OffreEmploi offre) {
        // Check if recruiter_id exists before inserting
        if (!isRecruiterExists(offre.getRecruiterId())) {
            System.err.println("Recruiter ID does not exist: " + offre.getRecruiterId());
            return false; // Prevent insertion
        }

        String sql = "INSERT INTO offre_emploi (titre, description, date_publication, recruiter_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, offre.getTitre());
            stmt.setString(2, offre.getDescription());
            stmt.setDate(3, new java.sql.Date(offre.getDatePublication().getTime()));
            stmt.setInt(4, offre.getRecruiterId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isRecruiterExists(int recruiterId) {
        String sql = "SELECT 1 FROM recruteur WHERE recruiter_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, recruiterId);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if recruiter exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
