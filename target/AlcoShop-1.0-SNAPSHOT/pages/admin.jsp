<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 05.12.2017
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/createAlc" method="post" enctype="multipart/form-data">
    Ім'я <input type="text" name="name"><br>
    Категорія
    <select name="category">
        <option value="vodka">Vodka</option>
        <option value="beer">Beer</option>
        <option value="vine">Wine</option>
    </select><br>
    Ціна
    <input type="text" name="price"><br>
    опис
    <textarea name="description"  cols="30" rows="10"></textarea><br>
    Кількість
    <input type="text" name="stock"><br>
    Статус
    <input type="radio" name="status" value="enabled">
    <input type="radio" name="status" value="disabled"><br>
    <input type="file" name="pic">
    <input type="submit" value="Додати">
</form>
<br>
<a href="/showOrders">Показати замовлення</a>
<c:forEach items="${orders}" var="order">
    <p>${order.id}</p>
    <p>${order.client}</p>
    <p>${order.name}</p>
</c:forEach>
</body>
</html>
