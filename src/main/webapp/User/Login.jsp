<%--
  Created by IntelliJ IDEA.
  User: oumay
  Date: 10/03/2025
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <%--@declare id="role"--%><label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="role">Role:</label>
    <select name="role">
        <option value="candidat">Candidat</option>
        <option value="recruteur">Recruteur</option>
    </select><br>
        <%-- Link to the registration page if the user doesn't have an account --%>
        <p>Don't have an account? <a href="Regester.jsp">Register here</a></p>
    <button type="submit">Login</button>
</form>

</body>
</html>
