package User.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import User.DAO.LoginDAO;
import User.Model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // "candidat" or "recruteur"

        LoginDAO loginDAO = null;
        try {
            loginDAO = new LoginDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Attempt to authenticate based on role
        User user = loginDAO.login(email, password, role);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if ("candidat".equals(user.getRole())) {
                response.sendRedirect("homeCandidat.jsp");
            } else if ("recruteur".equals(user.getRole())) {
                response.sendRedirect("homeRecruteur.jsp");
            }
        } else {
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}


