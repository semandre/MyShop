<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class=" hg-100 wd-100 mb-20">
    <div class="container">
        <div class="vertical-padding-20">
            <h1>Редагувати продукт</h1>
            <h4 class="mt-26">Будь ласка заповніть усі поля щоб добавити інформацію по продукту</h4>
        </div>
        <div class="row">
            <div class="col-md-12 text-center mt-57 ">
                <form  enctype="multipart/form-data" action="/editItem" method="post">
                    <div class="wd-60 m-auto">
                        <div class="row">
                            <div class="col-md-2 text-center">
                                <span class="spanSize ">Ім'я</span>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="name" class="inputSize" required ng-model="currentItem.name">
                            </div>
                        </div>
                        <div class="row mt-20">
                            <div class="col-md-3 text-left">
                                <span class="spanSize ">Категорія</span>
                            </div>
                            <div class="col-md-9">
                                <div class=" styled-select  semi-square">
                                    <select name="category" required>
                                        <%--<c:forEach items="${category}" var="category">--%>
                                        <option ng-repeat="category in categories track by $index" ng-model="currentItem.category" value="{{category.name}}" ng-selected="currentItem.category">{{category.name}}</option>
                                        <%--</c:forEach>--%>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-2 text-center">
                                <span class="spanSize ">Ціна</span>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="price" class="inputSize" required ng-model="currentItem.price">
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-4 text-center">
                                <span class="spanSize ">Фасування</span>
                            </div>
                            <div class="col-md-8">
                                <input type="text" name="packaging" class="inputSize" required placeholder="Введіть об'єм">
                            </div>
                        </div>


                        <div class="row mt-20">
                            <div class="col-md-12 text-center">
                                <span class="spanSize ">Опис</span>
                            </div>
                            <div class="col-md-12 mt-20">
                                <textarea rows="15" name="description" class="textArea" required ng-model="currentItem.description"></textarea>
                            </div>
                        </div>


                        <div class="row mt-20">
                            <div class="col-md-3 text-center">
                                <span class="spanSize ">Кількість</span>
                            </div>
                            <div class="col-md-9">
                                <input type="text" name="stock" class="inputSize" required ng-model="currentItem.stock" >
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-12 text-center">
                                <span class="spanSize ">Статус</span>
                            </div>
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-sm-6 ">
                                        <span class="radioSize">В наявності</span><input type="radio" name="status" value="В наявності" class="ml-30" required ng-model="currentItem.status">
                                    </div>
                                    <div class="col-sm-6">
                                        <span class="radioSize">Відсутній</span><input type="radio" name="status" value="Закінчився" class="ml-30" required ng-model="currentItem.status">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row ">
                            <div class="col-md-6 mt-20">
                                <input type="hidden" name="id" value="{{currentItem.id}}">

                            </div>
                            <div class="col-md-6 mt-20">
                                <input type="submit" value="Змінити" class="btn  addProdBtn">
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

