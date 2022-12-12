<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Home</h1>
<%
    if (session.getAttribute("loggedIn") == null) {
        response.sendRedirect("../index.jsp");
    }
    else{
    User user = (User) session.getAttribute("loggedIn");
    out.print("Hello " + user.getUsername() + "!");
    }
        User user = (User) session.getAttribute("loggedIn");
        if (user.getRandomInfo() != null){
            out.print("Your random info " + user.getRandomInfo() + " is sooo random!");
        }
    %>

    <br><br>
    <form action="RandomInfoServlet" method="post">
        <label for="randomInfo">Add some random info about yourself</label><br><br>
        <input type="text" id="randomInfo" name="randomInfo">
        <input type="submit" value="Add">
    </form>

<form action="<%= request.getContextPath()%>../RemoveSessionServlet" method="post">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>