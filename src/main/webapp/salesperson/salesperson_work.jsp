<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Salesperson work</title>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2016/bdt/style.css"/>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2016/bdt/jquery.bdt.min.css"/>
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2016/bdt/jquery.sortelements.js" type="text/javascript"></script>
    <script src="https://bootstraptema.ru/plugins/2016/bdt/jquery.bdt.min.js" type="text/javascript"></script>

</head>

<div class="container">
    <div class="row">
        <div class="box clearfix">
            <h2 class="text-center"><fmt:message key="translation.product"/></h2>
            <hr/>
            <table class="table table-hover" id="bootstrap-table">
                <thead>
                <tr>
                    <th><fmt:message key="translation.product"/></th>
                    <th><fmt:message key="translation.category"/></th>
                    <th><fmt:message key="translation.supplier"/></th>
                    <th><fmt:message key="translation.shop"/></th>
                    <th><fmt:message key="translation.count"/></th>
                    <th><fmt:message key="translation.price"/></th>
                    <th><fmt:message key="translation.final_price"/></th>
                    <th><fmt:message key="translation.delivery"/></th>
                    <th><fmt:message key="translation.date_ex"/></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="product" items="${requestScope.products}">
                    <c:if test="${sessionScope.id_shop==product.shop}" >

                        <tr
                                <c:forEach var="expiredProduct" items="${requestScope.expiredProduct}">
                                <c:if test="${expiredProduct.nameProductExpired==product.id}"> style="color: red"</c:if>
                                </c:forEach> >


                            <td>${product.name}</td>
                            <c:forEach var="categories" items="${requestScope.categories}">
                                <c:if test="${categories.id==product.categories}">
                                    <td>${categories.category}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="suppliers_id" items="${requestScope.suppliers}">
                                <c:if test="${suppliers_id.id==product.suppliers}">
                                    <td>${suppliers_id.nameSupplier}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="shop" items="${requestScope.shops}">
                                <c:if test="${shop.id==product.shop}">
                                    <td>${shop.nameShop}</td>
                                </c:if>
                            </c:forEach>
                            <td>${product.count}</td>
                            <td>${product.price}</td>
                            <c:forEach var="categories" items="${requestScope.categories}">
                                <c:if test="${categories.id==product.categories}">
                                    <td><fmt:formatNumber
                                            value="${product.price +(product.price * categories.interest / 100)}"
                                            maxFractionDigits="2"/></td>
                                </c:if>
                            </c:forEach>
                            <td>${product.localDate}</td>
                            <td>${product.date}</td>
                            <td>
                                <form action="/salesperson/salespersonWork" method="post">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <input type="hidden" name="name" value="${product.name}">
                                    <input type="hidden" name="categories_id" value="${product.categories}">
                                    <input type="hidden" name="suppliers_id" value="${product.suppliers}">
                                    <input type="hidden" name="shop_id" value="${product.shop}">
                                    <input type="hidden" name="price" value="${product.price}">
                                    <input type="hidden" name="delivery" value="${product.localDate}">
                                    <input type="hidden" name="date_expiration" value="${product.date}">
                                    <input type="hidden" name="count" value="${product.count}">
                                    <c:forEach var="categories" items="${requestScope.categories}">
                                        <c:if test="${categories.id==product.categories}">
                                            <input type="hidden" name="interest" value="${categories.interest}">
                                        </c:if>
                                    </c:forEach>
                                    <input type="hidden" name="nameSalesperson" value="${sessionScope.lastName}">
                                    <c:forEach var="shops" items="${requestScope.shops}">
                                        <c:if test="${shops.id==product.shop}">
                                            <input type="hidden" name="nameShop" value="${shops.nameShop}">
                                        </c:if>
                                    </c:forEach>
                                    <c:forEach var="orders" items="${requestScope.orders}">
                                        <input type="hidden" name="number" value="${orders.number}">
                                        <c:if test="${product.name==orders.product}">
                                            <input type="hidden" name="product" value="${orders.product}">
                                            <c:if test="${product.id==orders.id}">
                                                <input type="hidden" name="idOrder" value="${orders.id}">
                                            </c:if>

                                            <input type="hidden" name="quantum" value="${orders.quantum}">
                                        </c:if>

                                    </c:forEach>
                                    <button type="submit" class="W3">-</button>
                                </form>
                            </td>
                            <c:forEach var="expiredProduct" items="${requestScope.expiredProduct}">
                            <c:if test="${expiredProduct.nameProductExpired != 0}">
                            <c:if test="${expiredProduct.nameProductExpired==product.id}">
                                <td>

                                    <form action="/salesperson/addExpiredProductServlet" method="post">

                                        <input type="hidden" name="id" value="${product.id}">
                                        <input type="hidden" name="count" value="${product.count}">
                                        <input type="hidden" name="price" value="${product.price}">
                                        <input type="hidden" name="date_expiration" value="${product.date}">
                                        <button type="submit"><fmt:message key="translation.take"/></button>

                                    </form>

                                </td>
                            </c:if>
                            </c:if>
                            </c:forEach>
                        </tr>

                </c:if>

                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
    <ul>
        <form action="/salesperson/printOrder" method="post">
            <a>
                <c:forEach var="orders" items="${requestScope.orders}">
                    <input type="hidden" name="number" value="${orders.number}">
                    <input type="hidden" name="idProduct" value="${orders.id}">
                    <input type="hidden" name="product" value="${orders.product}">

                    <input type="hidden" name="quantum" value="${orders.quantum}">
                    <input type="hidden" name="localDate" value="${orders.localDate}">
                    <input type="hidden" name="priceFinal" value="${orders.priceFinal}"/>
                    <input type="hidden" name="sum" value="${orders.sum}">
                    <input type="hidden" name="nameSalesperson" value="${orders.nameSalesperson}">
                    <input type="hidden" name="nameShop" value="${orders.nameShop}">
                </c:forEach>
                <button type="submit" class="ui-button" href="/salesperson/printOrder"><fmt:message
                        key="translation.button.order"/></button>
            </a>
        </form>
    </ul>
    <ul>
        <a type="submit" class="btn btn-primary" href="/salesperson/salesperson_menu.jsp"><fmt:message
                key="translation.button.exit"/>
        </a>
    </ul>
</div>


<script>
    $(document).ready(function () {
        $('#bootstrap-table').bdt();
    });
</script>

<%--<div class="wrapper">--%>
<%--    <div class="flex">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-8 col-md-offset-2">--%>

<%--                <div class="fresh-table toolbar-color-blue">--%>

<%--                    <!-- Изменение фона таблицы: full-color-blue, full-color-azure, full-color-green, full-color-red, full-color-orange--%>
<%--                    Изменение фона тулбара страницы: toolbar-color-blue, toolbar-color-azure, toolbar-color-green, toolbar-color-red, toolbar-color-orange--%>
<%--                    -->--%>

<%--                    <div class="toolbar">--%>
<%--                        <button id="alertBtn" class="btn btn-default">Alert</button>--%>
<%--                    </div>--%>

<%--                    <table id="fresh-table" class="table" >--%>
<%--                        <thead>--%>

<%--                            <th data-field="name" data-sortable="true"><fmt:message key="translation.product"/></th>--%>
<%--                            <th data-field="categories" data-sortable="true"><fmt:message key="translation.category"/></th>--%>
<%--                            <th data-field="suppliers_id" data-sortable="true"><fmt:message key="translation.supplier"/></th>--%>
<%--                            <th data-field="shop" data-sortable="true"><fmt:message key="translation.shop"/></th>--%>
<%--                            <th data-field="final price" data-sortable="true"><fmt:message key="translation.final_price"/></th>--%>
<%--                            <th data-field="delivery" data-sortable="true"><fmt:message key="translation.delivery"/></th>--%>
<%--                            <th data-field="date expiration" data-sortable="true"><fmt:message key="translation.date_ex"/></th>--%>
<%--                            <th data-field="date" data-sortable="true"><fmt:message key="translation.count"/></th>--%>
<%--                            <th></th>--%>

<%--                        </thead>--%>
<%--                        <tbody>--%>

<%--                        <c:forEach var="product" items="${requestScope.products}">--%>
<%--                        <c:forEach var="expiredProduct" items="${requestScope.expiredProduct}">--%>
<%--                            <tr <c:if test="${expiredProduct.nameProductExpired==product.id}">--%>
<%--                                style="color: red" </c:if>>--%>
<%--                                <td>${product.name}</td>--%>
<%--                                <c:forEach var="categories" items="${requestScope.categories}">--%>
<%--                                    <c:if test="${categories.id==product.categories}">--%>
<%--                                        <td>${categories.category}</td>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                                <c:forEach var="suppliers_id" items="${requestScope.suppliers}">--%>
<%--                                    <c:if test="${suppliers_id.id==product.suppliers}">--%>
<%--                                        <td>${suppliers_id.nameSupplier}</td>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                                <c:forEach var="shop" items="${requestScope.shops}">--%>
<%--                                    <c:if test="${shop.id==product.shop}">--%>
<%--                                        <td>${shop.nameShop}</td>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                                <c:forEach var="categories" items="${requestScope.categories}">--%>
<%--                                    <c:if test="${categories.id==product.categories}">--%>
<%--                                        <td><fmt:formatNumber value="${product.price +(product.price * categories.interest / 100)}" maxFractionDigits="2"/></td>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                                <td>${product.localDate}</td>--%>
<%--                                <td>${product.date}</td>--%>
<%--                                <td>${product.count}</td>--%>
<%--                                <td>--%>

<%--                                <form action="/salesperson/salespersonWork" method="post">--%>
<%--                                  <input type="hidden" name="id" value="${product.id}">--%>
<%--                                  <input type="hidden" name="name" value="${product.name}">--%>
<%--                                  <input type="hidden" name="categories_id" value="${product.categories}">--%>
<%--                                  <input type="hidden" name="suppliers_id" value="${product.suppliers}">--%>
<%--                                  <input type="hidden" name="shop_id" value="${product.shop}">--%>
<%--                                  <input type="hidden" name="price" value="${product.price}">--%>
<%--                                  <input type="hidden" name="delivery" value="${product.localDate}">--%>
<%--                                  <input type="hidden" name="date_expiration" value="${product.date}">--%>
<%--                                  <input type="hidden" name="count" value="${product.count}">--%>
<%--                                    <c:forEach var="categories" items="${requestScope.categories}">--%>
<%--                                        <c:if test="${categories.id==product.categories}">--%>
<%--                                            <input type="hidden" name="interest" value="${categories.interest}">--%>
<%--                                        </c:if>--%>
<%--                                    </c:forEach>--%>
<%--                                    <input type="hidden" name="nameSalesperson" value="${sessionScope.lastName}">--%>
<%--                                    <c:forEach var="shops" items="${requestScope.shops}">--%>
<%--                                        <c:if test="${shops.id==product.shop}">--%>
<%--                                            <input type="hidden" name="nameShop" value="${shops.nameShop}">--%>
<%--                                        </c:if>--%>
<%--                                    </c:forEach>--%>
<%--                                  <c:forEach var="orders" items="${requestScope.orders}">--%>
<%--                                  <input type="hidden" name="number" value="${orders.number}">--%>
<%--                                      <c:if test="${product.name==orders.product}">--%>
<%--                                      <input type="hidden" name="product" value="${orders.product}">--%>
<%--                                      <c:if test="${product.id==orders.id}">--%>
<%--                                  <input type="hidden" name="idOrder" value="${orders.id}">--%>
<%--                                      </c:if>--%>

<%--                                  <input type="hidden" name="quantum" value="${orders.quantum}">--%>
<%--                                  </c:if>--%>

<%--                                  </c:forEach>--%>
<%--                                  <button type="submit" class="W3">-</button>--%>
<%--                                </form>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
<%--                        </c:forEach>--%>

<%--                        </tbody>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--               <a type="submit" class="button" href="/salesperson/salesperson_menu.jsp"><fmt:message key="translation.exit"/></a>--%>

<%--                <form action="/salesperson/printOrder" method="post">--%>
<%--                <a>--%>
<%--                        <c:forEach var="orders" items="${requestScope.orders}">--%>
<%--                            <input type="hidden" name="number" value="${orders.number}">--%>
<%--                            <input type="hidden" name="idProduct" value="${orders.id}">--%>
<%--                            <input type="hidden" name="product" value="${orders.product}">--%>
<%--                            <input type="hidden" name="quantum" value="${orders.quantum}">--%>
<%--                            <input type="hidden" name="localDate" value="${orders.localDate}">--%>
<%--                            <input type="hidden" name="priceFinal" value="${orders.priceFinal}"/>--%>
<%--                            <input type="hidden" name="sum" value="${orders.sum}">--%>
<%--                            <input type="hidden" name="nameSalesperson" value="${orders.nameSalesperson}">--%>
<%--                            <input type="hidden" name="nameShop" value="${orders.nameShop}">--%>
<%--                        </c:forEach>--%>
<%--                            <button type="submit" class="ui-button" href="/salesperson/printOrder"><fmt:message key="translation.button.order"/></button>--%>
<%--                </a>--%>
<%--            </form>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


</html>