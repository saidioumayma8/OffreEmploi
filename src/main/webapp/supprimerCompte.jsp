<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supprimer mon compte</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Supprimer mon compte</h1>

        <form action="CandidateServlet" method="post">
            <input type="hidden" name="action" value="delete" /> <!-- Indicating the action for the servlet -->

            <div class="alert alert-warning text-center">
                <p>Êtes-vous sûr de vouloir supprimer votre compte ? Cette action est irréversible.</p>
            </div>

            <button type="submit" class="btn btn-danger btn-block">Supprimer mon compte</button>
        </form>

        <p class="text-center mt-3"><a href="Condidat.jsp">Retour à la page principale</a></p>
    </div>
</body>
</html>
