<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 17.04.2023
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin</h1>
<c:forEach var="person" items="${requestScope.personsAdmin}">
    <ul>
        <li><c:out  value="${person.firstName}"/></li>
        <li><c:out  value="${person.lastName}"/></li>
        <li><c:out  value="${person.email}"/></li>
        <li><c:out  value="${person.login}"/></li>
        <li><c:out  value="${person.password}"/></li>
    </ul>


</c:forEach>

</body>
</html>
