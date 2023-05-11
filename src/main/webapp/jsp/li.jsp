<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 16.04.2023
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rows</title>
</head>
<body>

<h2>All persons</h2>
<c:forEach var="person" items="${requestScope.persons}">
    <ul>
        <li><c:out  value="${person.firstName}"/></li>
        <li><c:out  value="${person.lastName}"/></li>
        <li><c:out  value="${person.email}"/></li>
        <li><c:out  value="${person.login}"/></li>
        <li><c:out  value="${person.password}"/></li>
    </ul>


</c:forEach>

<h1>New Person</h1>
    <form method="post" action="/pageList">
       <label> <input type="text" name="firstName" placeholder="enter your name"/> Name</label><br>
       <label> <input type="text" name="lastName" placeholder="enter your family"/> Family</label><br>
       <label> <input type="email" name="email" placeholder="enter your email"/> email</label><br>
       <label> <input type="text" name="login" placeholder="enter your login"/>login</label><br>
       <label> <input type="password" name="password" placeholder="enter your password"/>password</label><br>
       <input type="submit" value="ok" name="ok"/>
    </form>

</body>
</html>
