<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Recruteur.Model.OffreEmploi" %>
<%
    List<OffreEmploi> offres = (List<OffreEmploi>) request.getAttribute("offres");
%>
<html>
<head>
    <title>Liste des Offres d'Emploi</title>
</head>
<body>
<h2>Liste des Offres d'Emploi</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Description</th>
        <th>Date de Publication</th>
    </tr>
    <% for (OffreEmploi o : offres) { %>
    <tr>
        <td><%= o.getOffreId() %></td>
        <td><%= o.getTitre() %></td>
        <td><%= o.getDescription() %></td>
        <td><%= o.getDatePublication() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
