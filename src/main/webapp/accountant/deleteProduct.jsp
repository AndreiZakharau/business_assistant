<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Delete product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-body">
            <h1><fmt:message key="translation.delete_product"/></h1>

            <form action="/accountant/deleteProduct" method="post">

                <div class="form-group row card-body" >
                    <label for="products" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.product"/></label>
                    <select class="col-xl-7 col-sm-12"
                            name="products" id="products">
                        <c:forEach var="product" items="${requestScope.products}">
                            <option name="products" value="${product.id}" > ${product.id} ${product.name} ${product.count}
                                    ${product.price} ${product.categories} ${product.suppliers} ${product.localDate}
                                    ${product.date} ${product.shop}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row card-body" >
                    <label for="id" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.id"/></label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="<fmt:message key="translation.ed"/>">
                    </div>
                </div>


                <button type="submit" class="btn btn-primary"><fmt:message key="translation.button.delete"/></button>
            </form>
        </div>
        <ul>
            <a  type="submit" class="active" href="/accountant/delete_all.jsp"><fmt:message key="translation.exit"/></a>
        </ul>
    </div>
</div>
</body>
</html>
