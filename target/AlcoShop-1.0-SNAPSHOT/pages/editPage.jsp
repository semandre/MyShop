<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class=" hg-100 wd-100 mb-20">
    <div class="container" ng-controller="adminsViewCtrl">
        <div class="vertical-padding-20">
            <h1>Редагувати продукт</h1>
            <h4 class="mt-26">Будь ласка заповніть усі поля щоб добавити інформацію по продукту</h4>
        </div>
        <div class="row">
            <div class="col-md-12 text-center mt-57 ">
                <form action="/createAlc" method="post" enctype="multipart/form-data">
                    <div class="wd-60 m-auto">
                        <div class="row">
                            <div class="col-md-2 text-center">
                                <span class="spanSize ">Ім'я</span>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="name" class="inputSize" required value="{{currentItem.name}}">
                            </div>
                        </div>
                        <div class="row mt-20">
                            <div class="col-md-3 text-left">
                                <span class="spanSize ">Категорія</span>
                            </div>
                            <div class="col-md-9">
                                <div class=" styled-select  semi-square">
                                    <select name="category" required ng-repeat="category in categories">
                                        <%--<c:forEach items="${category}" var="category">--%>
                                        <option value="{{category.name}}">{{category.name}}</option>
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
                                <input type="text" name="price" class="inputSize" required value="{{currentItem.price}}">
                            </div>
                        </div>


                        <div class="row mt-20">
                            <div class="col-md-12 text-center">
                                <span class="spanSize ">Опис</span>
                            </div>
                            <div class="col-md-12 mt-20">
                                <input type="text" name="description" class="textArea" required>
                            </div>
                        </div>


                        <div class="row mt-20">
                            <div class="col-md-3 text-center">
                                <span class="spanSize ">Кількість</span>
                            </div>
                            <div class="col-md-9">
                                <input type="text" name="stock" class="inputSize" required value="{{currentItem.stock}}" >
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-12 text-center">
                                <span class="spanSize ">Статус</span>
                            </div>
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-sm-6 ">
                                        <span class="radioSize">В наявності</span><input type="radio" name="status" value="enabled" class="ml-30" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <span class="radioSize">Відсутній</span><input type="radio" name="status" value="disabled" class="ml-30" required>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row ">
                            <div class="col-md-6 mt-20">
                                <div class="btn  addProdBtn text-center" title="" >
                                    <input type="file" name="pic" required value="Вибрати файл">
                                </div>

                            </div>
                            <div class="col-md-6 mt-20">
                                <input type="submit" value="Додати" class="btn  addProdBtn">
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
