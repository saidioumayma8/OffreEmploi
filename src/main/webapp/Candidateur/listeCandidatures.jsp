<%@ page import="java.util.List" %>
<%@ page import="Candidateur.Model.Candidateur, Candidateur.DAO.CandidateurDAO" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Utils.DatabaseConnection" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Candidatures</title>
    <link rel="stylesheet" href="styles.css">
    <script>
        // Fonction de tri des colonnes
        function sortTable(n) {
            let table = document.getElementById("candidaturesTable");
            let rows, switching = true, shouldSwitch, i;
            let dir = "asc", switchcount = 0;

            while (switching) {
                switching = false;
                rows = table.rows;

                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    let x = rows[i].getElementsByTagName("TD")[n].innerText.toLowerCase();
                    let y = rows[i + 1].getElementsByTagName("TD")[n].innerText.toLowerCase();

                    if ((dir === "asc" && x > y) || (dir === "desc" && x < y)) {
                        shouldSwitch = true;
                        break;
                    }
                }

                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    switchcount++;
                } else if (switchcount === 0 && dir === "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }

        // Fonction de filtrage par statut
        function filterStatus() {
            let filter = document.getElementById("statusFilter").value.toLowerCase();
            let table = document.getElementById("candidaturesTable");
            let rows = table.getElementsByTagName("tr");

            for (let i = 1; i < rows.length; i++) {
                let statusCell = rows[i].getElementsByTagName("td")[3];
                if (statusCell) {
                    let statusText = statusCell.innerText.toLowerCase();
                    rows[i].style.display = (filter === "" || statusText === filter) ? "" : "none";
                }
            }
        }
    </script>
</head>
<body>

<h2>Liste des Candidatures</h2>

<!-- Filtre par statut -->
<label for="statusFilter">Filtrer par statut :</label>
<select id="statusFilter" onchange="filterStatus()">
    <option value="">Tous</option>
    <option value="en attente">En attente</option>
    <option value="accepte">Accepté</option>
    <option value="refuse">Refusé</option>
</select>

<%
    Connection conn = null;
    try {
        conn = DatabaseConnection.getConnection();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    CandidateurDAO dao = new CandidateurDAO(conn);
    List<Candidateur> candidatures = dao.getAllCandidatures();
%>

<table border="1" id="candidaturesTable">
    <tr>
        <th onclick="sortTable(0)">ID ⬍</th>
        <th onclick="sortTable(1)">Candidat ⬍</th>
        <th onclick="sortTable(2)">Offre ⬍</th>
        <th onclick="sortTable(3)">Statut ⬍</th>
        <th>Actions</th>
    </tr>
    <% for (Candidateur c : candidatures) { %>
    <tr>
        <td><%= c.getCandidatureId() %></td>
        <td><%= c.getCandidate().getNom() %></td>
        <td><%= c.getOffreEmploi().getTitre() %></td>
        <td><%= c.getStatus() %></td>
        <td>
            <!-- Modifier -->
            <form action="CandidatureServlet" method="post" style="display:inline;">
                <input type="hidden" name="candidatureId" value="<%= c.getCandidatureId() %>">
                <select name="status">
                    <option value="EN_ATTENTE" <%= c.getStatus().equals("EN_ATTENTE") ? "selected" : "" %>>En attente</option>
                    <option value="ACCEPTE" <%= c.getStatus().equals("ACCEPTE") ? "selected" : "" %>>Accepté</option>
                    <option value="REFUSE" <%= c.getStatus().equals("REFUSE") ? "selected" : "" %>>Refusé</option>
                </select>
                <button type="submit">Modifier</button>
            </form>

            <!-- Supprimer -->
            <form action="CandidatureServlet" method="post" style="display:inline;" onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cette candidature ?');">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="candidatureId" value="<%= c.getCandidatureId() %>">
                <button type="submit" style="background-color: red; color: white;">Supprimer</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>

<br><a href="HomeCand.jsp">Retour</a>

</body>
</html>
