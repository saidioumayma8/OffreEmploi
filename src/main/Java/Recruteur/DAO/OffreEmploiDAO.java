package Recruteur.DAO;

import Recruteur.Model.OffreEmploi;
import Utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreEmploiDAO {
    private static Connection connection;

    public OffreEmploiDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createOffre(OffreEmploi offre) {
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

    public static List<OffreEmploi> getAllOffres() throws SQLException {
        List<OffreEmploi> offres = new ArrayList<>();
        connection= DatabaseConnection.getConnection();

        if (connection == null) {
            System.err.println("❌ ERROR: Database connection is NULL in DAO!");
            return offres;
        }

        String query = "SELECT * FROM offre_emploi";
        System.out.println("🔍 DEBUG: Executing SQL - " + query);

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("offre_id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date datePublication = rs.getDate("date_publication");

                System.out.println("✅ Found: ID=" + id + ", Titre=" + titre);

                OffreEmploi offre = new OffreEmploi();
                offre.setOffreId(id);
                offre.setTitre(titre);
                offre.setDescription(description);
                offre.setDatePublication(datePublication);
                offres.add(offre);
            }

            System.out.println("✅ Total offres retrieved: " + offres.size()); // Debugging line

        } catch (SQLException e) {
            System.err.println("❌ SQL ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        return offres;
    }

}
