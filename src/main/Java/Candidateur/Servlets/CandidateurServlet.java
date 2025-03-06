package Candidateur.Servlets;

import Candidat.Model.Candidat;
import Candidateur.DAO.CandidateurDAO;
import OffreEmploi.Model.OffreEmploi;
import Candidateur.Model.Candidateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/CandidatureServlet")
public class CandidateurServlet extends HttpServlet {

    private CandidateurDAO candidatureDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OffreEmploi", "root", "password");
            candidatureDAO = new CandidateurDAO(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int candidateId = Integer.parseInt(request.getParameter("candidateId"));
        int offreId = Integer.parseInt(request.getParameter("offreId"));

        Candidat candidat = new Candidat(candidateId, null, null, null, null, null);
        OffreEmploi offreEmploi = new OffreEmploi(offreId, null, null, null);
        Candidateur candidateur = new Candidateur(0, Candidateur.CandidatureStatus.EN_ATTENTE, candidat, offreEmploi);

        if (candidatureDAO.addCandidature(candidateur)) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int candidatureId = Integer.parseInt(request.getParameter("candidatureId"));
        String status = request.getParameter("status");

        if (candidatureDAO.updateCandidatureStatus(candidatureId, Candidature.CandidatureStatus.valueOf(status))) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int candidatureId = Integer.parseInt(request.getParameter("candidatureId"));

        if (candidatureDAO.deleteCandidature(candidatureId)) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}


