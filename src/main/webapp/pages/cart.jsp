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

<div class="modal">
    <div class="modal-content">
        <div class="white container hg-100 wd-100 mt-87">
            <div class="container" ng-controller="mainViewCtrl">
                <div class="cartContainer pt-20" >
                    <%--<c:forEach items="${listCart}" var="item">--%>
                    <div class="row b-btm pt-20" ng-repeat="item in cartItems" >
                        <div class="col-sm-2 text-center">
                            <span name="name" id="name">{{item.name}}</span>
                        </div>
                        <div class="col-sm-2 text-center">
                            <span>{{item.price}} грн</span>
                        </div>
                        <div class="clo-sm-1 text-center">
                            <button ng-click="removeOne()" class=" quant m-auto" >-</button>
                        </div>

                        <div class="col-sm-2 text-center">
                            <input type="number"  value="{{item.quantity}}" id="quantity" name="quantity" disabled style="width: 50px"/>
                        </div>
                        <div class="clo-sm-1 text-center">
                            <button ng-click="addOne()" class=" quant m-auto" >+</button>
                        </div>
                        <div class="col-sm-2 text-center">
                            <span>{{item.quantity*item.price}} грн</span>
                        </div>
                        <div class="col-sm-2 text-center">
                            <button ng-click="remove()" class=" btn addToCartBtn">Видалити</button>
                        </div>

                    </div>

                    <%--</c:forEach>--%>

                </div>
                <br>
                <a href="#" class="btn  addToCartBtn">До товару</a>
            </div>

            <div class="container">
                <div class="former mt-20">
                    <div class="nameForm col-sm-4 mt-5">
                        <h3 class="text-left">Оформлення замовлення</h3>
                        <form action="/order" method="post">
                            <input type="text" name="name" placeholder="Ім'я" class="inputForm" required><br>
                            <input type="text" name="lastName" placeholder="Прізвище" class="inputForm" required><br>
                            <input type="email" name="email" placeholder="e-mail" class="inputForm" required><br>
                            <input type="text" name="address" placeholder="Адреса" class="inputForm" required><br>
                            <input type="text" name="number" placeholder="Номер телефону" class="inputForm" required><br>
                            <input type="submit" value="Замовити" class="btn addToCartBtn mt-20">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
