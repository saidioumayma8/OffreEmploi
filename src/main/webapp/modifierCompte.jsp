<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier mon compte</title>
</head>
<body>
    <h1>Modifier mon compte</h1>
    <form action="modifierCompte" method="post" enctype="multipart/form-data">
        <label for="nouveauNom">Nom:</label>
        <input type="text" id="nouveauNom" name="nouveauNom" value="John Doe" required><br>

        <label for="nouveauEmail">Email:</label>
        <input type="email" id="nouveauEmail" name="nouveauEmail" value="john.doe@example.com" required><br>

        <label for="nouveauTel">Téléphone:</label>
        <input type="tel" id="nouveauTel" name="nouveauTel" value="0123456789" required><br>

        <label for="nouveauCv">Nouveau CV (PDF uniquement):</label>
        <input type="file" id="nouveauCv" name="nouveauCv" accept=".pdf"><br>

        <input type="submit" value="Mettre à jour">
    </form>

    <p><a href="index.jsp">Retour à la page principale</a></p>
</body>
</html>
