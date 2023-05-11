<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
</head>

<body>
<h1>You ordered </h1>
<table id="pizza">
<c:forEach var="item" items="${pizzaItem}">

  <tr>
    <th>New Item</th>
  </tr>
    <tr>
      <th>Pizza name</th>
      <th>Pizza coast</th>
    </tr>
    <tr>
      <td>${item.pizza.name}</td>
      <td>${item.pizza.coast}</td>
    </tr>
    <tr>
      <th>name addition</th>
      <th>coast addition</th>
    </tr>
    <c:forEach var="addition" items="${item.additionList}">

      <tr>
        <td>${addition.name}</td>
        <td>${addition.coast}</td>
      </tr>
    </c:forEach>


</c:forEach>
  <tr>
    <th>Total Coast</th>
  </tr>
  <tr>
    <td>${totalCoast}</td>
  </tr>
</table>


<button onclick="location.href='/pizzaPage'">Go to Buy</button>
<button onclick="location.href='/delivery'">make a purchase</button>
</body>
</html>