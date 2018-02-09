<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 06.02.2018
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<div class="former">
<div class="nameForm col-sm-4">
<h3 class="text-left">Оформлення замовлення</h3>
<form action="/order" method="post">
<input type="text" name="name" placeholder="Ім'я" class="inputForm" required><br>
<input type="text" name="lastName" placeholder="Прізвище" class="inputForm" required><br>
<input type="email" name="email" placeholder="e-mail" class="inputForm" required><br>
    <input type="text" class="inputForm" name="cityName" ng-model="test"  autocomplete="off" required ng-focus="focus()"  placeholder="Введіть місто">
    <select size="5" ng-model="test" class="searchSelect" ng-show="focused" >
        <option ng-repeat="city in cities | filter:test" value="{{city.cityName}}"  >{{city.cityName}}</option>
    </select>
<input type="text" name="address" placeholder="Адреса" class="inputForm" required><br>
<input type="text" name="number" placeholder="Номер телефону" class="inputForm" required><br>
<input type="submit" value="Замовити" class="btn addToCartBtn mt-20">

</form>
</div>
</div>
</div>
