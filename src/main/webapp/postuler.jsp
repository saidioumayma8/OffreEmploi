<%@ page import="java.util.List" %>
<%@ page import="Candidat.Model.Candidat, Recruteur.Model.OffreEmploi, Candidateur.DAO.CandidateurDAO" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Postuler</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<h2>Postuler à une Offre</h2>

<%
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OffreEmploi", "root", "admin");
    CandidateurDAO dao = new CandidateurDAO(conn);
    List<Candidat> candidats = dao.getAllCandidates();
    List<OffreEmploi> offres = dao.getAllOffres();
%>

<form action="CandidatureServlet" method="post">
    <label>Candidat :</label>
    <select name="candidateId" required>
        <option value="">-- Sélectionner --</option>
        <% for (Candidat c : candidats) { %>
        <option value="<%= c.getId() %>"><%= c.getNom() %> <%= c.getPrenom() %></option>
        <% } %>
    </select>

    <label>Offre d'emploi :</label>
    <select name="offreId" required>
        <option value="">-- Sélectionner --</option>
        <% for (OffreEmploi o : offres) { %>
        <option value="<%= o.getOffreId() %>"><%= o.getTitre() %></option>
        <% } %>
    </select>

    <button type="submit">Postuler</button>
</form>

</body>
</html>
