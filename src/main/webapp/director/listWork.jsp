<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2016/bdt/style.css" />
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2016/bdt/jquery.bdt.min.css" />
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2016/bdt/jquery.sortelements.js" type="text/javascript"></script>
    <script src="https://bootstraptema.ru/plugins/2016/bdt/jquery.bdt.min.js" type="text/javascript"></script>
</head>
<div class="container">
    <div class="row">
        <div class="box clearfix">
            <h2 class="text-center">My products</h2>
            <hr />
            <table class="table table-hover" id="bootstrap-table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Category</th>
                    <th>Supplier</th>
                    <th>Shop</th>
                    <th>Count</th>
                    <th>Price</th>
                    <th>Final price</th>
                    <th>Delivery</th>
                    <th>Date expiration</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${requestScope.products}">
                    <tr>

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
                                <td><fmt:formatNumber value="${product.price +(product.price * categories.interest / 100)}" maxFractionDigits="2"/></td>
                            </c:if>
                        </c:forEach>
                        <td>${product.localDate}</td>
                        <td>${product.date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <ul>
        <a  type="submit" class="btn btn-primary" href="/director/directors_work_page.jsp">EXIT</a>
    </ul>
</div>


<script>
    $(document).ready( function () {
        $('#bootstrap-table').bdt();
    });
</script>
</html>
