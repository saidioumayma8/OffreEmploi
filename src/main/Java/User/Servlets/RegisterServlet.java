package User.Servlets;

import User.DAO.RegisterDAO;
import User.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form values from request
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Create a new User object and set values
        User user = new User();
        user.setNom(nom);
        user.setEmail(email);
        user.setPassword(password); // Hash the password in real application
        user.setRole(role);

        // Create DAO object to interact with the database
        RegisterDAO registerDAO = null;
        try {
            registerDAO = new RegisterDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Attempt to register the user
        if (registerDAO.registerUser(user)) {
            // Registration successful, redirect to login page
            response.sendRedirect("login.jsp");
        } else {
            // Registration failed, display error
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
    }
}
