package Candidat.Servlets;
import Candidat.DAO.CandidatDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/CandidateServlet")
public class CandidatServlet extends HttpServlet {
    private CandidatDAO candidatDAO = new CandidatDAO();

    // DoPost pour gérer les actions de création, modification et suppression de compte
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération de l'action (create, update, delete) depuis la requête
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    creerCompte(request, response);
                    break;
                case "update":
                    modifierCompte(request, response);
                    break;
                case "delete":
                    supprimerCompte(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp"); // Si l'action est inconnue
                    break;
            }
        } else {
            response.sendRedirect("error.jsp"); // Si aucune action n'est spécifiée
        }
    }

    // Méthode pour créer un compte candidat
    private void creerCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String cv = request.getParameter("cv");
        boolean isRegistered = candidatDAO.creerCompte(nom, email, password, tel, cv);

        if (isRegistered) {
            response.sendRedirect("success.jsp"); // Redirige vers une page de succès
        } else {
            response.sendRedirect("error.jsp"); // Redirige vers une page d'erreur
        }
    }

    // Méthode pour modifier un compte candidat
    private void modifierCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String cv = request.getParameter("cv");

        boolean isUpdated = candidatDAO.modifierCompte(id, nom, email, password, tel, cv);

        if (isUpdated) {
            response.sendRedirect("success.jsp"); // Redirige vers la page de profil mis à jour
        } else {
            response.sendRedirect("error.jsp"); // Redirige vers une page d'erreur
        }
    }

    // Méthode pour supprimer un compte candidat
    private void supprimerCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));

        boolean isDeleted = candidatDAO.deleteAccount(id);

        if (isDeleted) {
            response.sendRedirect("success.jsp"); // Redirige vers une page de compte supprimé
        } else {
            response.sendRedirect("error.jsp"); // Redirige vers une page d'erreur
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
