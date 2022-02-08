<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h2 class="text-center"><fmt:message key="translation.product"/></h2>
            <hr />
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
                    <tr <c:forEach var="expiredProduct" items="${requestScope.expiredProduct}">
                            <c:if test="${expiredProduct.nameProductExpired==product.id}">
                        style="color: red" </c:if> </c:forEach> >

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
        <a type="submit" class="button" href="/jsp/accountant/accountant_menu.jsp"><fmt:message key="translation.exit"/></a></a>
    </ul>

</div>


<script>
    $(document).ready( function () {
        $('#bootstrap-table').bdt();
    });
</script>
</html>
