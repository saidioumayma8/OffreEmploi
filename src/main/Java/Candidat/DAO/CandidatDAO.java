package Candidat.DAO;
import java.sql.*;
import java.sql.Connection;
import static Candidat.Utils.DatabaseConnection.getConnection;

public class CandidatDAO {

    public boolean creerCompte(String nom, String email, String password, String tel, String cv) {
        Connection conn = null;
        PreparedStatement psUser = null, psCondidat = null;
        boolean isRegistered = false;

        try {
            // Connexion à la base de données
            conn = getConnection();

            // Insertion dans la table 'users'
            String userQuery = "INSERT INTO users (nom, email, password, tel, cv) VALUES (?, ?, ?, ?, ?, ?)";
            psUser = conn.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, nom);
            psUser.setString(2, email);
            psUser.setString(3, password);
            psUser.setString(4, tel);
            psUser.setString(5, cv);

            // Exécution de la requête d'insertion dans la table 'user'
            int affectedRows = psUser.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = psUser.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);

                    // Insertion dans la table 'patient'
                    String patientQuery = "INSERT INTO patient (user_id, nom, email, password, tel, cv) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    psCondidat = conn.prepareStatement(patientQuery);
                    psCondidat.setInt(1, id);
                    psCondidat.setString(2, nom);
                    psCondidat.setString(3, email);
                    psCondidat.setString(4, password);
                    psCondidat.setString(5, tel);
                    psCondidat.setString(6, cv);

                    // Exécution de la requête d'insertion dans la table 'patient'
                    psCondidat.executeUpdate();

                    // Si l'insertion a réussi, on marque l'inscription comme réussie
                    isRegistered = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isRegistered;
    }
    public boolean modifierCompte(int id, String nom, String email, String password, String tel, String cv){
        Connection conn = null;
        PreparedStatement psUser = null, psCandidate = null;
        boolean isUpdated = false;

        try {
            // Connexion à la base de données
            conn = getConnection();

            // Mise à jour dans la table 'users'
            String userQuery = "UPDATE users SET nom = ?, email = ?, password = ? WHERE user_id = ?";
            psUser = conn.prepareStatement(userQuery);
            psUser.setString(1, nom);
            psUser.setString(2, email);
            psUser.setString(3, password);
            psUser.setInt(4, id);

            int userUpdated = psUser.executeUpdate();

            // Mise à jour dans la table 'candidates'
            String candidateQuery = "UPDATE candidates SET tel = ?, cv = ? WHERE candidate_id = ?";
            psCandidate = conn.prepareStatement(candidateQuery);
            psCandidate.setString(1, tel);
            psCandidate.setString(2, cv);
            psCandidate.setInt(3, id);

            int candidateUpdated = psCandidate.executeUpdate();

            // Si les deux mises à jour ont réussi, on marque comme mis à jour
            if (userUpdated > 0 && candidateUpdated > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    // Méthode pour supprimer un compte de candidat
    public boolean deleteAccount(int id) {
        Connection conn = null;
        PreparedStatement psCandidate = null, psUser = null;
        boolean isDeleted = false;

        try {
            // Connexion à la base de données
            conn = getConnection();

            // Suppression des informations du candidat dans la table 'candidates'
            String candidateQuery = "DELETE FROM candidates WHERE candidate_id = ?";
            psCandidate = conn.prepareStatement(candidateQuery);
            psCandidate.setInt(1, id);

            int candidateDeleted = psCandidate.executeUpdate();

            // Suppression des informations de l'utilisateur dans la table 'users'
            String userQuery = "DELETE FROM users WHERE user_id = ?";
            psUser = conn.prepareStatement(userQuery);
            psUser.setInt(1, id);

            int userDeleted = psUser.executeUpdate();

            // Si la suppression dans les deux tables a réussi
            if (candidateDeleted > 0 && userDeleted > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}

<<<<<<< HEAD
=======

>>>>>>> 390e30d50698d749c31be0538f364e8534707b78
