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
import java.util.List;

@WebServlet("/afficherOffres")
public class AfficherOffresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = (Connection) getServletContext().getAttribute("DB_CONNECTION");
        OffreEmploiDAO offreDAO = new OffreEmploiDAO(connection);

        List<OffreEmploi> offres = offreDAO.getAllOffres();
        request.setAttribute("offres", offres);
        request.getRequestDispatcher("afficherOffres.jsp").forward(request, response);
    }
}
