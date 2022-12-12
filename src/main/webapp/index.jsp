<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginControllerServlet" method="post">
    <input type="text" placeholder="Username" name="username"><br>
    <input type="password" placeholder="Password" name="password"><br>
    <input type="submit" value="Log in">
    <p>${error}</p>
</form>
</body>
</html>