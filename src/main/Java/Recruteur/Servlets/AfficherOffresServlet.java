package Recruteur.Servlets;

import Recruteur.DAO.OffreEmploiDAO;
import Recruteur.Model.OffreEmploi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/afficherOffres")
public class AfficherOffresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Connection to the database
        Connection connection = (Connection) getServletContext().getAttribute("DB_CONNECTION");
        OffreEmploiDAO offreDAO = new OffreEmploiDAO(connection);

        // Retrieve all job offers
        List<OffreEmploi> offres = null;
        try {
            offres = offreDAO.getAllOffres();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Pass the list to the JSP
        request.setAttribute("offres", offres);

        // Forward the request to the JSP
        request.getRequestDispatcher("/OffreEmploi/AfficheOffreEmploi.jsp").forward(request, response);
    }
}






