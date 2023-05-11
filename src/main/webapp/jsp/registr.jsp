<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 17.04.2023
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registr</title>
</head>
<body>
<h1>Registration</h1>
<form method="post" action="/registry">
    <label> <input type="text" name="firstName" placeholder="enter your name"/> Name</label><br>
    <label> <input type="text" name="lastName" placeholder="enter your family"/> Family</label><br>
    <label> <input type="email" name="email" placeholder="enter your email"/> email</label><br>
    <label> <input type="text" name="login" placeholder="enter your login"/>login</label><br>
    <label> <input type="password" name="password" placeholder="enter your password"/>password</label><br>
    <input type="submit" value="ok" name="ok"/>
</form>

</body>
</html>
