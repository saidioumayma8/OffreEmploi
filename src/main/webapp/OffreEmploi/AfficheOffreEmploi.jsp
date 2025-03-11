<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Recruteur.Model.OffreEmploi" %>
<%@page import="Recruteur.DAO.*" %>

<%

    List<OffreEmploi> offres = OffreEmploiDAO.getAllOffres();
%>

<html>
<head>
    <title>Liste des Offres d'Emploi</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">📄 Liste des Offres d'Emploi</h2>

    <% if (offres == null || offres.isEmpty()) { %>
    <div class="alert alert-warning text-center" role="alert">
        ❌ Aucun offre disponible pour le moment.
    </div>
    <% } else { %>
    <p class="text-success fw-bold">✅ Nombre d'offres disponibles : <%= offres.size() %></p>
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Date de Publication</th>
            </tr>
            </thead>
            <tbody>
            <% for (OffreEmploi offre : offres) { %>
            <tr>
                <td><%= offre.getOffreId() %></td>
                <td><%= offre.getTitre() %></td>
                <td><%= offre.getDescription() %></td>
                <td><%= offre.getDatePublication() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <% } %>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

