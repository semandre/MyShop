<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 05.12.2017
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="home_header.jsp"%>
<div class="white container hg-100 wd-100 mt-87">
    <div class="container">
            <div class="adminHead">
                <h2>Вітаю на сторінці Адміністратора</h2>
            </div>
            <div class="row">
                <div class="col-md-6 text-center mt-57 ">
                    <a href="/addProduct" class=" btn btn-success adminsBtn">Додати товар</a>
                </div>
                <div class="col-md-6 text-center mt-57 ">
                    <a href="/showOrders" class=" btn btn-success adminsBtn">Показати замовлення</a>
                </div>
            </div>


            <input type="text" name="name" id="cName" required>
            <button id="ctgBtn">add</button>


        <input type="text" name="cityName" id="cityName">
        <button id="cityNameBtn">find city</button>

    </div>
</div>
<%@include file="footer.jsp"%>
