<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un compte</title>
</head>
<body>
    <h1>Créer un compte</h1>
    <form action="creerCompte" method="post" enctype="multipart/form-data">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="tel">Téléphone:</label>
        <input type="tel" id="tel" name="tel" required><br>

        <label for="cv">CV (PDF uniquement):</label>
        <input type="file" id="cv" name="cv" accept=".pdf" required><br>

        <input type="submit" value="Créer mon compte">
    </form>

    <p>Vous avez déjà un compte ? <a href="index.jsp">Retour à la page principale</a></p>
</body>
</html>
