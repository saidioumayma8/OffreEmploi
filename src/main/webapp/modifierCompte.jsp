<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier mon compte</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Modifier mon compte</h1>

        <form action="CandidatServlet" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nouveauNom">Nom:</label>
                <input type="text" class="form-control" id="nouveauNom" name="nouveauNom" value="John Doe" required>
            </div>

            <div class="form-group">
                <label for="nouveauEmail">Email:</label>
                <input type="email" class="form-control" id="nouveauEmail" name="nouveauEmail" value="john.doe@example.com" required>
            </div>

            <div class="form-group">
                <label for="nouveauTel">Téléphone:</label>
                <input type="tel" class="form-control" id="nouveauTel" name="nouveauTel" value="0123456789" required>
            </div>

            <div class="form-group">
                <label for="nouveauCv">Nouveau CV :</label>
                <input type="text" class="form-control" id="nouveauCv" name="nouveauCv" required>
            </div>

            <button type="submit" class="btn btn-warning btn-block">Mettre à jour</button>
        </form>

        <p class="text-center mt-3"><a href="Condidat.jsp">Retour à la page principale</a></p>
    </div>

</body>
</html>
