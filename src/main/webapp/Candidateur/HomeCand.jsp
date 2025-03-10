<%@ page import="java.util.List" %>
<%@ page import="Recruteur.Model.OffreEmploi" %>
<%@ page import="Candidateur.DAO.CandidateurDAO" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Recruteur.DAO.OffreEmploiDAO" %>
<%@ page import="Utils.DatabaseConnection" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Offres d'emploi</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body { font-family: Arial, sans-serif; text-align: center; background: #f4f4f4; padding: 20px; }
        .container { max-width: 800px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 0px 10px gray; }
        .job { border-bottom: 1px solid #ccc; padding: 10px; }
        a { display: inline-block; padding: 10px; background: #28a745; color: white; text-decoration: none; margin-top: 10px; }
        a:hover { background: #218838; }
    </style>
</head>
<body>

<div class="container">
    <h2>Liste des Offres d'Emploi</h2>

    <%
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        OffreEmploiDAO dao = new OffreEmploiDAO(conn);
        List<OffreEmploi> offres = dao.getAllOffres();

        for (OffreEmploi offre : offres) {
    %>
    <div class="job">
        <h3><%= offre.getTitre() %></h3>
        <p><%= offre.getDescription() %></p>
        <a href="postuler.jsp?offreId=<%= offre.getOffreId() %>">Postuler</a>
    </div>
    <% } %>

    <br><a href="listeCandidatures.jsp">Voir les candidatures</a>
    <br><a href="../index.jsp">Go to Home !</a>
</div>

</body>
</html>
