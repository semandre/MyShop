<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="home_header.jsp"%>
<!-- Masthead -->



    <div class="white container mt-87" ng-controller="mainViewCtrl">
        <button class="cart" id="cartBtn">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
        </button>
        <div class="head">
            <div id="cbp-fwslider" class="cbp-fwslider">
                <ul>
                    <li><a href="#"><img src="/resources/img/1.jpg" alt="img01"/></a></li>
                    <li><a href="#"><img src="/resources/img/2.jpg" alt="img02"/></a></li>
                    <li><a href="#"><img src="/resources/img/3.jpg" alt="img03"/></a></li>
                    <li><a href="#"><img src="/resources/img/4.jpg" alt="img04"/></a></li>
                    <li><a href="#"><img src="/resources/img/5.jpg" alt="img05"/></a></li>
                </ul>
            </div>
        </div>


        <!-- Items List -->

        <div class="container">
            <div class="row">
                <div class="col-lg-2 ">
                    <div class="container">
                        <div class="row mt-20 mb-20">
                            <div class="dropdown">
                                <button onclick="myFunction()" class="dropbtn ">Категорії</button>
                                <div id="myDropdown" class="dropdown-content" ng-repeat="category in categories">
                                        <a href="/{{category.id}}" class="col-lg-12 category mt-2">{{category.name}}</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-lg-10 my-auto" >

                        <div class="row" id="">
                            <div class="col-lg-4  prod-block mt-20"  ng-repeat="item in items">
                                <h2 class="text-center"><a href="/viewProduct/{{item.id}}">{{item.name}}</a></h2>
                                <div class="prod-img"><img src="{{item.pic}}" alt="img" width="150px" height="200px"></div>
                                <div class="row">
                                <span class="d-inline-block col-xs-6 col-md-6 text-center">
                            <span class="ff-tah price-theme mb-20 va-m">{{item.price}}грн</span>
                                </span>
                                    <span class="d-inline-block col-xs-6 col-md-6   text-center">
                            <button class="btn  addToCartBtn mt-26 " ng-click="addToCart()">В корзину</button>
                                        <%--<a href="/add/${alc.id}" class="btn btn-success  addToCartBtn mt-26 ">В корзину</a>--%>
                                </span>
                                </div>

                            </div>
                        </div>

                </div>
            </div>
        </div>




        <div class="container">
            <div class="section-heading text-center">
                <h2>Unlimited Features, Unlimited Fun</h2>
                <p class="text-muted">Check out what you can do with this app theme!</p>
                <hr>
            </div>
            <div class="row">
                <div class="col-lg-4 my-auto">
                    <div class="device-container">
                        <div class="device-mockup iphone6_plus portrait white">
                            <div class="device">
                                <div class="screen">
                                    <!-- Demo image for screen mockup, you can put an image here, some HTML, an animation, video, or anything else! -->
                                    <img src="/resources/img/demo-screen-1.jpg" class="img-fluid" alt="">
                                </div>
                                <div class="button">
                                    <!-- You can hook the "home button" to some JavaScript events or just remove it -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 my-auto">
                    <div class="container-fluid">
                        <div class="row">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium ad adipisci aliquam architecto asperiores aspernatur commodi consectetur cumque, deserunt eaque facere fugit harum id incidunt iusto laborum, libero mollitia obcaecati officia officiis omnis optio quaerat quas rem repellendus sapiente similique tempora? Accusamus ad autem eligendi mollitia quis! Accusamus autem, consequatur corporis debitis deserunt distinctio dolorum ea eaque earum, eos eum exercitationem hic illum itaque laboriosam laudantium maxime minima minus modi non, nulla officiis quibusdam quo rem rerum sunt voluptates! A, aperiam beatae cum eveniet ex expedita id ipsum laboriosam laudantium minima minus mollitia nisi odit porro repudiandae suscipit veniam, voluptatem.
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal" id="modal"  ng-controller="mainViewCtrl">
            <div class="modal-content">
                <div class="white container hg-100 wd-100 mt-87">
                    <div class="container" ng-show="cartView=='cart'">
                        <div class="cartContainer " >
                            <%--<c:forEach items="${listCart}" var="item">--%>
                            <div class="row b-btm mt-20" ng-repeat="item in cartItems" >
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
                        <div class="row mt-20">
                            <div class="col-sm-6 text-left">
                                <button  class="btn  addToCartBtn" id="closeBtn">До товару</button>
                            </div>
                            <div class="col-sm-6 text-right">
                                <button  class="btn  addToCartBtn" ng-disabled="isEmpty" ng-click="checkout()">Замовити</button>
                            </div>
                        </div>
                    </div>
                    <ng-include src="'/pages/order.jsp'" ng-show="cartView=='order'"></ng-include>

                </div>
            </div>
        </div>
    </div>





<%@include file="footer.jsp"%>



