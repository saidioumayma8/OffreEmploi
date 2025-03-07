package Recruteur.Servlets;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import Utils.DatabaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import Recruteur.DAO.OffreEmploiDAO;
import Recruteur.Model.OffreEmploi;

@WebServlet("/create-offre")
public class CreateOffreServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Database connection established!");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT 1");
                if (resultSet.next()) {
                    System.out.println("Connection is valid.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database connection failed", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        try {
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            String dateStr = request.getParameter("date_publication");
            int recruiterId = Integer.parseInt(request.getParameter("recruiter_id"));

            if (titre == null || description == null || dateStr == null) {
                response.getWriter().write("Error: Missing fields");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = sdf.parse(dateStr);

            OffreEmploi offre = new OffreEmploi();
            offre.setTitre(titre);
            offre.setDescription(description);
            offre.setDatePublication(utilDate);
            offre.setRecruiterId(recruiterId);

            OffreEmploiDAO dao = new OffreEmploiDAO(connection);
            boolean isCreated = dao.createOffre(offre);

            if (isCreated) {
                response.getWriter().write("Offer successfully created!");
            } else {
                response.getWriter().write("Error: Could not create offer. Recruiter ID might not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
