<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Job Offer</title>
</head>
<body>
<h1>Create Job Offer</h1>
<form action="/OffreEmploi/create-offre" method="POST">

    <label for="titre">Title:</label>
    <input type="text" id="titre" name="titre" required>
    <br><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea>
    <br><br>
    <label for="date_publication">Date of Publication:</label>
    <input type="date" id="date_publication" name="date_publication" required>
    <br><br>
    <label for="recruiter_id">Recruiter ID:</label>
    <input type="number" id="recruiter_id" name="recruiter_id" required>
    <br><br>
    <button type="submit">Create Offer</button>
</form>
</body>
</html>
