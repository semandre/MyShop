<%--
  Created by IntelliJ IDEA.
  User: Андрій
  Date: 09.01.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class=" hg-100 wd-100 mb-20">
    <div class="container">
        <div class="vertical-padding-20">
            <h1>Додати продукт</h1>
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
                                <input type="text" name="name" class="inputSize" required>
                            </div>
                        </div>
                        <div class="row mt-20">
                            <div class="col-md-3 text-left">
                                <span class="spanSize ">Категорія</span>
                            </div>
                            <div class="col-md-9">
                                <div class=" styled-select  semi-square">
                                    <select name="category" required">
                                            <option ng-repeat="category in categories" value="{{category.name}}">{{category.name}}</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-2 text-center">
                                <span class="spanSize ">Ціна</span>
                            </div>
                            <div class="col-md-10">
                                <input type="text" name="price" class="inputSize" required>
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
                                <textarea type="text" name="description" class="textArea" required></textarea>
                            </div>
                        </div>


                        <div class="row mt-20">
                            <div class="col-md-3 text-center">
                                <span class="spanSize ">Кількість</span>
                            </div>
                            <div class="col-md-9">
                                <input type="text" name="stock" class="inputSize" required>
                            </div>
                        </div>

                        <div class="row mt-20">
                            <div class="col-md-12 text-center">
                                <span class="spanSize ">Статус</span>
                            </div>
                            <div class="col-md-12">
                                <div class="row">
                                    <div class="col-sm-6 ">
                                        <span class="radioSize">В наявності</span><input type="radio" name="status" value="В наявності" class="ml-30" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <span class="radioSize">Відсутній</span><input type="radio" name="status" value="Закінчився" class="ml-30" required>
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
