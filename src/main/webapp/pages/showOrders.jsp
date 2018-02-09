<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 09.01.2018
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="white container hg-100 wd-100 ">
    <div class="container pt-20">
                        <div class="text-center">
                            <h1>Замовлення</h1>
                        </div>
                       <div class="row b-btm" >
                           <div class="col-sm-4 mt-20" ng-repeat="order in orders">
                                       <div class="col-sm-12 text-center">
                                           <span>{{order.clientName}}</span>
                                           <span>{{order.lastName}}</span>
                                       </div>
                                       <div class="col-sm-12 text-center">
                               <span>
                                   {{order.cityName}}
                               </span>
                                           <span>{{order.address}}</span>
                                       </div>
                                       <div class="col-sm-12 text-center">
                                           <span><b>Тел:</b> 0{{order.number}}</span>
                                       </div>

                                       <div class="col-sm-12 text-center">
                                           <div class="text-center" ng-repeat="list in order.cartList">
                                               <span><b>Назва:</b> {{list.name}}</span>
                                               <span><b>Кількість:</b> {{list.quantity}}</span>
                                               <span><b>Ціна:</b> {{list.price*list.quantity}} грн</span>

                                           </div>
                                           <button class="btn addToCartBtn" ng-click="sendOrder(order)">Відправити</button>
                                       </div>

                               </div>
                           </div>
                       </div>


                <%--</c:forEach>--%>

    </div>
</div>

