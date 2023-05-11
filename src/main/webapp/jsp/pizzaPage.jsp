<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 19.04.2023
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pizza</title>
</head>

<body>
    <h1>Choose your pizza</h1>
    <c:forEach var="pizza" items="${pizzaList }">
        <div>
            <form action="/pizzaPage" method="post">
                <input type="hidden" name="id" value="${pizza.id}"/>
                Название: <p>${pizza.name}</p>
                Цена: <p>${pizza.coast}</p>
                Addition:
                <input type="checkbox" name="addition" value="olive"/>olive
                <input type="checkbox" name="addition" value="caperse"/>capers
                <input type="checkbox" name="addition" value="cheese"/>cheese
                <input type="checkbox" name="addition" value="anchouse"/>anchouse

                <br><br>
                <input type="submit" value="add to cart"/>

            </form>

        </div>

    </c:forEach>

<br><br>
<button onclick="location.href='/cart'">корзина</button>


</body>

</html>


