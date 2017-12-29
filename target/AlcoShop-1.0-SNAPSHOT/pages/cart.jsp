<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 09.12.2017
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="home_header.jsp"%>

    <div class="white container hg-100 wd-100 mtr-10">
        <div class="container">
            <table class="table  ml-5 mt-100">
                <tr>
                    <th>Назва продукту</th>
                    <th>Ціна</th>
                    <th>Кількість</th>
                    <c:if test="${total!=0}">
                        <th>До оплати: ${total} грн</th>
                    </c:if>
                </tr>
                <c:forEach items="${listCart}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>
                            <input type="number"  value="${item.quantity}" name="quantity" style="width: 50px"/>
                        </td>
                        <td>${item.price.longValue()*item.quantity}</td>
                        <td>
                            <a href="/remove/${item.id}" class=" btn btn-danger addToCartBtn">Видалити</a>
                            <a href="/update/${item.name}" class=" btn btn-success addToCartBtn">Оновити</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="/" class="btn btn-success addToCartBtn">До товару</a>
        </div>

        <div class="container">
            <div class="former mt-20">
                <div class="nameForm col-sm-4 mt-5">
                    <h3 class="text-left">Оформлення замовлення</h3>
                    <form action="/order" method="post">
                        <input type="text" name="name" placeholder="Ім'я" class="inputForm" required><br>
                        <input type="text" name="lastName" placeholder="Прізвище" class="inputForm" required><br>
                        <input type="text" name="address" placeholder="Адреса" class="inputForm" required><br>
                        <input type="text" name="number" placeholder="Номер телефону" class="inputForm" required><br>
                        <input type="submit" value="Замовити" class="btn btn-success addToCartBtn mt-20">
                    </form>
                </div>
            </div>
        </div>
    </div>




<%@include file="footer.jsp"%>