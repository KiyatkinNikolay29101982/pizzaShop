<%--
  Created by IntelliJ IDEA.
  User: kiyat
  Date: 05.05.2023
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delivery and Pay</title>
</head>
<script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3Af82bced2a12177633e66822ccb639af4d03ece7d6e9ab811057ab49eb8126929&amp;width=934&amp;height=647&amp;lang=ru_RU&amp;scroll=true"></script>
<body>
<h1>Enter your address</h1>
    <form action="/delivery" method="post">
        <label><input type="text" name="city" placeholder="Enter your city"/></label>
        <br><br>
        <label><input type="text" name="street" placeholder="Enter your street"/></label>
        <br><br>
        <label><input type="text" name="building" placeholder="Enter number your building"/></label>
        <br><br>
        <button type="submit">Submit</button>
    </form>

</body>
</html>
