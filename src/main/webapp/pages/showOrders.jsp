<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 09.01.2018
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="white container hg-100 wd-100 mtr-10">
    <div class="container">

        <c:forEach items="${orders}" var="order">
            <p>${order.clientName}</p>
            <p>${order.lastName}</p>
            <p>${order.address}</p>
            <p>${order.number}</p>
            <p>${order.PName}</p>
            <p>${order.price}</p>
            <p>${order.quantity}</p>
        </c:forEach>
    </div>
</div>
<%@include file="footer.jsp"%>
