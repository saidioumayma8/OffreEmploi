<%@ page import="java.util.List" %>
<%@ page import="Candidat.Model.Candidat, Recruteur.Model.OffreEmploi, Candidateur.DAO.CandidateurDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Candidat.DAO.CandidatDAO" %>
<%@ page import="Recruteur.DAO.OffreEmploiDAO" %>
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
    CandidatDAO dao = new CandidatDAO();
    List<Candidat> candidats = dao.getAllCandidates();
    List<OffreEmploi> offres = null;
    try {
        offres = OffreEmploiDAO.getAllOffres();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>

<form action="CandidatureServlet" method="post">
    <label>Candidat :</label>
    <select name="candidateId" required>
        <option value="">-- Sélectionner --</option>
        <% for (Candidat c : candidats) { %>
        <option value="<%= c.getId() %>"><%= c.getNom() %></option>
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
