<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 09.01.2018
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="white container hg-100 wd-100 mt-87">
    <div class="container pt-20">

        <div class="wd-60 mt-20 m-auto">
            <div>
                   <div class="order-block">
                       <div class="row" ng-repeat="order in orders">
                           <span class= "spanSize col-sm-6 pl-5">Замовник</span>
                           <div class="col-sm-6">
                               <span class="spanSize  ">{{order.clientName}}</span>
                               <span class="spanSize">{{order.lastName}}</span>
                           </div>
                           <span class="spanSize col-sm-6 pl-5">Адреса</span>
                           <div class="col-sm-6">
                               <span class="spanSize">{{order.cityName}}</span>
                               <span class="spanSize ml-2">{{order.address}}</span>
                           </div>
                           <span class="col-sm-6 spanSize pl-5">Номер телефону</span>
                           <span class="spanSize col-sm-6">0{{order.number}}</span>
                       </div>
                       <div class="text-center">
                           <span class="spanSize">Замовлення</span>
                           <%--<c:forEach items="${order.cartList}" var="list">--%>
                               <div class="text-center" ng-repeat="list in order.cartList">
                                   <div>
                                       <span>{{list.name}}</span>
                                       <span>{{list.price}}</span>
                                       <span>{{list.quantity}}</span>
                                       <button class="btn btn-success addToCartBtn">Delete</button>
                                   </div>
                               </div>
                           <%--</c:forEach>--%>
                       </div>
                   </div>
                <%--</c:forEach>--%>
            </div>
        </div>
    </div>
</div>

