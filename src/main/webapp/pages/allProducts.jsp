
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class=" hg-100 wd-100 mb-20">
    <div class="container">
        <div class="cartContainer pt-20 b-btm"  >
                <div class="row" ng-repeat="item in items">
                    <div class="col-sm-2 text-center">
                        <span name="name" id="name">{{item.name}}</span>
                    </div>
                    <div class="col-sm-2 text-center">
                        <span><b>Ціна:</b> {{item.price}}</span>
                    </div>

                    <div class="col-sm-2 text-center">
                        <span>{{item.category}}</span>
                    </div>

                    <div class="col-sm-2 text-center">
                        <span><b>К-ксть:</b> {{item.stock}}</span>
                    </div>

                    <div class="col-sm-2 text-center">
                        <span>{{item.status}}</span>
                    </div>
                    <div class="col-sm-2 text-center">
                        <button class="addToCartBtn btn" ng-click="edit(item)">Змінити</button>
                        <button class="addToCartBtn btn" ng-click="deleteItem(item)">Видалити</button>
                    </div>
                </div>
        </div>

    </div>
</div>
