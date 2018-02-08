<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 06.12.2017
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="home_header.jsp"%>
<div class="white container wd-100 hg-100" ng-controller="mainViewCtrl">
    <section class="features-icons  text-center">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="${alcogol.pic}" alt="img" style="width: 300px;height: 400px">
                </div>
                <div class="col-md-7">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 borDs headName">
                                <h1 class="text-center ">${alcogol.name}</h1>
                            </div>
                            <div class="col-md-12 borDs headName">
                                    <p class="text-left mb-0">Категорія:${alcogol.category.name}</p>
                                    <p class="text-left mb-0">Статус:${alcogol.status}</p>
                            </div>
                            <div class="col-md-12 borDs headName">
                                <div class="positioner">
                                    <span class="text-orange priceText">Ціна</span>
                                    <div class="priceBlock text-center ">

                                        <span>${alcogol.price}</span>
                                        <span>Грн</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 borDs headName">
                                <button ng-click="addOne()"  class="btn  addToCartBtn mt-26 ">В корзину</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container mt-100">
            <div class="row">
                <div class="col-md-12 same">
                    <span class="font-weight-bold "><p class="text-left describer borDs">Опис</p></span>
                    <p class="desriberText text-left">${alcogol.description}</p>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="footer.jsp"%>
