package Candidateur.Servlets;

import Candidat.Model.Candidat;
import Candidateur.DAO.CandidateurDAO;
import Recruteur.Model.OffreEmploi;
import Candidateur.Model.Candidateur;
import Utils.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/CandidatureServlet")
public class CandidateurServlet extends HttpServlet {

    private CandidateurDAO candidatureDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            candidatureDAO = new CandidateurDAO(connection);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erreur de connexion à la base de données");
        }
    }

    /**
     * Afficher la liste des candidatures
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidateur> candidatures = candidatureDAO.getAllCandidatures();
        request.setAttribute("candidatures", candidatures);
        request.getRequestDispatcher("listeCandidatures.jsp").forward(request, response);
    }

    /**
     * Ajouter une nouvelle candidature
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("postuler".equals(action)) {
            try {
                int candidateId = Integer.parseInt(request.getParameter("candidateId"));
                int offreId = Integer.parseInt(request.getParameter("offreId"));

                Candidat candidat = new Candidat(candidateId, null, null, null, null, null);
                OffreEmploi offreEmploi = new OffreEmploi(offreId, null, null, null);
                Candidateur candidateur = new Candidateur(0, candidat, offreEmploi, Candidateur.CandidatureStatus.EN_ATTENTE);

                if (candidatureDAO.addCandidature(candidateur)) {
                    response.sendRedirect("postuler.jsp?message=Votre candidature a été enregistrée avec succès.");
                } else {
                    response.sendRedirect("postuler.jsp?message=Erreur lors de la soumission de votre candidature.");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("postuler.jsp?message=Veuillez sélectionner un candidat et une offre valide.");
            }
        } else if ("modifier".equals(action)) {
            // Modifier une candidature
            try {
                int candidatureId = Integer.parseInt(request.getParameter("candidatureId"));
                String status = request.getParameter("status");

                if (candidatureDAO.updateCandidatureStatus(candidatureId, Candidateur.CandidatureStatus.valueOf(status))) {
                    response.sendRedirect("listeCandidatures.jsp?message=Statut mis à jour avec succès.");
                } else {
                    response.sendRedirect("listeCandidatures.jsp?message=Erreur lors de la mise à jour.");
                }
            } catch (IllegalArgumentException e) {
                response.sendRedirect("listeCandidatures.jsp?message=Statut invalide.");
            }
        } else if ("supprimer".equals(action)) {
            // Supprimer une candidature
            try {
                int candidatureId = Integer.parseInt(request.getParameter("candidatureId"));

                if (candidatureDAO.deleteCandidature(candidatureId)) {
                    response.sendRedirect("listeCandidatures.jsp?message=Candidature supprimée.");
                } else {
                    response.sendRedirect("listeCandidatures.jsp?message=Erreur lors de la suppression.");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("listeCandidatures.jsp?message=ID invalide.");
            }
        }
    }
}
