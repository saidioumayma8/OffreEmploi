<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supprimer mon compte</title>
</head>
<body>
    <h1>Supprimer mon compte</h1>
    <form action="supprimerCompte" method="post">
        <p>Êtes-vous sûr de vouloir supprimer votre compte ? Cette action est irréversible.</p>
        <input type="submit" value="Supprimer mon compte" style="color: red;">
    </form>

    <p><a href="index.jsp">Retour à la page principale</a></p>
</body>
</html>
