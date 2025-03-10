<%@ page import="java.util.List" %>
<%@ page import="Candidateur.Model.Candidateur, Candidateur.DAO.CandidateurDAO" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Candidatures</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<h2>Liste des Candidatures</h2>

<%
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OffreEmploi", "root", "password");
    CandidateurDAO dao = new CandidateurDAO(conn);
    List<Candidateur> candidatures = dao.getAllCandidatures();
%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Candidat</th>
        <th>Offre</th>
        <th>Statut</th>
    </tr>
    <% for (Candidateur c : candidatures) { %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getCandidate().getNom() %> <%= c.getCandidate().getPrenom() %></td>
        <td><%= c.getOffreEmploi().getTitre() %></td>
        <td><%= c.getStatus() %></td>
    </tr>
    <% } %>
</table>

<br><a href="index.jsp">Retour</a>

</body>
</html>
