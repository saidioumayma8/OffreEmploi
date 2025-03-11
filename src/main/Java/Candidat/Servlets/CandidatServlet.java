package Candidat.Servlets;

import Candidat.DAO.CandidatDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CandidateServlet")
public class CandidatServlet extends HttpServlet {
    private CandidatDAO candidatDAO = new CandidatDAO();

    // DoPost to handle create, update, delete actions
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    creerCompte(request, response);
                    break;
                case "update":
                    updateCompte(request, response);
                    break;
                case "delete":
                    supprimerCompte(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Create a new candidate account
    private void creerCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String cv = request.getParameter("cv");
        String userType = request.getParameter("userType");  // Added userType to differentiate candidate/recruiter

        boolean isRegistered = candidatDAO.creerCompte(nom, email, password, tel, cv, userType);

        if (isRegistered) {
            response.sendRedirect("OffreEmploi/AfficheOffreEmploi.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Update candidate details
    private void updateCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String cv = request.getParameter("cv");

        boolean isUpdated = candidatDAO.updateCandidate(id, nom, email, tel, cv);

        if (isUpdated) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    // Delete a candidate account
    private void supprimerCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));

        boolean isDeleted = candidatDAO.deleteAccount(id);

        if (isDeleted) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
