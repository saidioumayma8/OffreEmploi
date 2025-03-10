package Candidat.DAO;
import Candidat.Model.Candidat;
import Candidat.Utils.DatabaseConnection;
import Candidat.Model.Candidat;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

                    // Insertion dans la table 'candidates'
                    String candidatesQuery = "INSERT INTO candidates (user_id, nom, email, password, tel, cv) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    psCondidat = conn.prepareStatement(candidatesQuery);
                    psCondidat.setInt(1, id);
                    psCondidat.setString(2, nom);
                    psCondidat.setString(3, email);
                    psCondidat.setString(4, password);
                    psCondidat.setString(5, tel);
                    psCondidat.setString(6, cv);

                    // Exécution de la requête d'insertion dans la table 'candidates'
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


        public List<Candidat> getAllCandidates() {
            List<Candidat> candidates = new ArrayList<>();
            String sql = "SELECT c.candidate_id, u.nom, u.email, c.tel, c.cv FROM candidates c JOIN users u ON c.candidate_id = u.user_id";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Candidat candidate = new Candidat();
                    candidate.setId(rs.getInt("candidate_id"));
                    candidate.setNom(rs.getString("nom"));
                    candidate.setEmail(rs.getString("email"));
                    candidate.setTel(rs.getString("tel"));
                    candidate.setCv(rs.getString("cv"));
                    candidates.add(candidate);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return candidates;
        }
    }

