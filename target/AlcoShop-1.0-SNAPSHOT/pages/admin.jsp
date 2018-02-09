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
                <h1>Вітаю на сторінці Адміністратора</h1>
            </div>
            <div class="row" ng-controller="adminsViewCtrl">
                <div class="col-md-2 mt-20">
                   <ul class="buttonList text-center">
                       <li> <button ng-click="showProducts()" class="adminsBtn">Усі продукти</button> </li>
                       <li> <button ng-click="addProduct()" class="adminsBtn">Додати товар</button>
                          </li>
                       <li> <button ng-click="addCategory()" class="adminsBtn">Додати категорію</button></li>
                       <li> <button ng-click="addCity()" class="adminsBtn">Додати місто</button></li>
                       <li> <button ng-click="showOrders()" class="adminsBtn">Показати замовлення</button></li>

                   </ul>
                </div>
                <div class="col-md-10 text-center mt-20" >
                    <div ng-show="currentView=='none'">
                        <span class="non-used">Виберіть дію з пункту меню</span>

                    </div>
                    <ng-include src="'/pages/editPage.jsp'" ng-show="currentView=='edit'"></ng-include>
                    <ng-include src="'/pages/allProducts.jsp'" ng-show="currentView=='products'"></ng-include>
                    <ng-include src="'/pages/addProduct.jsp'" ng-show="currentView=='add'"></ng-include>
                    <ng-include src="'/pages/showOrders.jsp'" ng-show="currentView=='orders'"></ng-include>

                    <div class="hg-100 wd-100 mb-20" ng-show="currentView=='category'">
                        <span class="non-used">Тут ви можете добавити свою категорію продукту</span>
                        <form ng-submit="addNewCategory(category)">
                            <div class="row ">
                                <div class="col-sm-8 mt-57">
                                    <input type="text" ng-model="category" class="inputSize" placeholder="Введіть категорію(напр : Пиво)">
                                </div>
                                <div class="col-sm-4 mt-57">
                                    <button type="submit" class="btn addProdBtn" >Додати</button>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="hg-100 wd-100 mb-20" ng-show="currentView=='city'">
                        <span class="non-used">Тут ви можете добавити місто для відправки продуктів</span>
                        <form  ng-submit="addNewCity(city)">
                            <div class="row ">
                                <div class="col-sm-8 mt-57">
                                    <input type="text" ng-model="city" class="inputSize" placeholder="Введіть назву міста">
                                    <span>{{msg}}</span>
                                </div>
                                <div class="col-sm-4 mt-57">
                                    <button type="submit" class="btn addProdBtn" >Додати</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <%--<input type="text" name="name" id="cName" required>--%>
            <%--<button id="ctgBtn">add</button>--%>


        <%--<form action="/find" method="post">--%>
            <%--<input type="text" name="cityName" id="cityName">--%>
            <%--&lt;%&ndash;<button id="cityNameBtn">find city</button>&ndash;%&gt;--%>
            <%--<input type="submit" value="addCity">--%>
        <%--</form>--%>



    </div>
</div>
<%@include file="footer.jsp"%>
