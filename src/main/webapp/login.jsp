<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if ("admin".equals(username) && "password".equals(password)) {
        response.sendRedirect("profile.jsp");
        return;
    }
%>


<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login.jsp" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <br>
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>

