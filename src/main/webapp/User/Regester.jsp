<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form action="/OffreEmploi/register" method="post">
    <label for="nom">Name:</label>
    <input type="text" name="nom" id="nom" required><br>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br>

    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required><br>

    <label for="role">Role:</label>
    <select name="role" id="role" required>
        <option value="candidat">Candidat</option>
        <option value="recruteur">Recruteur</option>
    </select><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
