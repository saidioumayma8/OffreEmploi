<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un compte</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Créer un compte</h1>

        <form action="CandidateServlet" method="post">
            <input type="hidden" name="action" value="create" />
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="tel">Téléphone:</label>
                <input type="tel" class="form-control" id="tel" name="tel" required>
            </div>

            <div class="form-group">
                <label for="cv">CV :</label>
                <input type="text" class="form-control" id="cv" name="cv" required>
            </div>

            <div class="form-group">
                <label for="userType">Type d'utilisateur:</label>
                <select class="form-control" id="userType" name="userType" required>
                    <option value="CANDIDATE">Candidat</option>
                    <option value="RECRUITER">Recruteur</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Créer mon compte</button>
        </form>

        <p class="text-center mt-3">Vous avez déjà un compte ? <a href="Condidat.jsp">Retour à la page principale</a></p>
    </div>
</body>
</html>
