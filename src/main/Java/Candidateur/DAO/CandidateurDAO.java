package Candidateur.DAO;

import Candidat.Model.Candidat;
import Recruteur.Model.OffreEmploi;
import Candidateur.Model.Candidateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateurDAO {

    private Connection connection;

    public CandidateurDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter une nouvelle candidature
    public boolean addCandidature(Candidateur candidature) {
        String query = "INSERT INTO candidature (status, candidate_id, offre_id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, candidature.getStatus().toString());
            ps.setInt(2, candidature.getCandidate().getId());
            ps.setInt(3, candidature.getOffreEmploi().getOffreId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Récupérer une candidature par son ID
    public Candidateur getCandidatureById(int candidatureId) {
        String query = "SELECT * FROM candidature WHERE candidature_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, candidatureId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Candidateur(
                        rs.getInt("candidature_id"),
                        Candidateur.CandidatureStatus.valueOf(rs.getString("status")),
                        new Candidat(rs.getInt("candidate_id"), null, null, null, null, null),
                        new OffreEmploi(rs.getInt("offre_id"), null, null, null)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Mettre à jour le statut d'une candidature
    public boolean updateCandidatureStatus(int candidatureId, Candidateur.CandidatureStatus status) {
        String query = "UPDATE candidature SET status = ? WHERE candidature_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, status.toString());
            ps.setInt(2, candidatureId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer une candidature
    public boolean deleteCandidature(int candidatureId) {
        String query = "DELETE FROM candidature WHERE candidature_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, candidatureId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lister toutes les candidatures
    public List<Candidateur> getAllCandidatures() {
        List<Candidateur> candidatures = new ArrayList<>();
        String query = "SELECT * FROM candidature";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                candidatures.add(new Candidateur(
                        rs.getInt("candidature_id"),
                        Candidateur.CandidatureStatus.valueOf(rs.getString("status")),
                        new Candidat(rs.getInt("candidate_id"), null, null, null, null, null),
                        new OffreEmploi(rs.getInt("offre_id"), null, null, null)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatures;
    }
}

