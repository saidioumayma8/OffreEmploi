package Candidat.DAO;

import Candidat.Model.Candidat;
import java.sql.*;
import static Candidat.Utils.DatabaseConnection.getConnection;

public class CandidatDAO {

    // CREATE - Method to create a new candidate account
    public boolean creerCompte(String nom, String email, String password, String tel, String cv, String userType) {
        Connection conn = null;
        PreparedStatement psUser = null, psCandidate = null;
        boolean isRegistered = false;

        try {
            conn = getConnection();

            String userQuery = "INSERT INTO users (nom, email, password, user_type) VALUES (?, ?, ?, ?)";
            psUser = conn.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, nom);
            psUser.setString(2, email);
            psUser.setString(3, password);
            psUser.setString(4, userType);


            int affectedRows = psUser.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = psUser.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);

                    if ("CANDIDATE".equals(userType)) {
                        String candidateQuery = "INSERT INTO candidates (candidate_id, tel, cv) VALUES (?, ?, ?)";
                        psCandidate = conn.prepareStatement(candidateQuery);
                        psCandidate.setInt(1, id);
                        psCandidate.setString(2, tel);
                        psCandidate.setString(3, cv);
                        psCandidate.executeUpdate();
                    }

                    isRegistered = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psUser != null) psUser.close();
                if (psCandidate != null) psCandidate.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isRegistered;
    }


    public boolean updateCandidate(int id, String nom, String email, String tel, String cv) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isUpdated = false;

        try {
            conn = getConnection();
            String query = "UPDATE candidates SET tel = ?, cv = ? WHERE candidate_id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, tel);
            ps.setString(2, cv);
            ps.setInt(3, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Now update in 'users' table
                String userQuery = "UPDATE users SET nom = ?, email = ? WHERE user_id = ?";
                ps = conn.prepareStatement(userQuery);
                ps.setString(1, nom);
                ps.setString(2, email);
                ps.setInt(3, id);

                rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    isUpdated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUpdated;
    }

    public boolean deleteAccount(int id) {
        Connection conn = null;
        PreparedStatement psCandidate = null, psUser = null;
        boolean isDeleted = false;

        try {
            conn = getConnection();

            String candidateQuery = "DELETE FROM candidates WHERE candidate_id = ?";
            psCandidate = conn.prepareStatement(candidateQuery);
            psCandidate.setInt(1, id);
            int candidateDeleted = psCandidate.executeUpdate();

            String userQuery = "DELETE FROM users WHERE user_id = ?";
            psUser = conn.prepareStatement(userQuery);
            psUser.setInt(1, id);
            int userDeleted = psUser.executeUpdate();

            if (candidateDeleted > 0 && userDeleted > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psCandidate != null) psCandidate.close();
                if (psUser != null) psUser.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isDeleted;
    }
}
