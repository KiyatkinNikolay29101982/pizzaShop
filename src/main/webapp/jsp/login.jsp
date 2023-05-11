<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 17.04.2023
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
  <form method="post" action="/login">
    login<input type="text" name="login" placeholder="enter your login"/>
    password<input type="password" name="password" placeholder="enter your password"/>
    <input class="button" type="submit" value="enter">
  </form>
</div>
</body>
</html>
