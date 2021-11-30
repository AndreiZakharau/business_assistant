<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1>Update product</h1>

            <form action="/accountant/updateProduct" method="post">

                <div class="form-group row card-body" >
                    <label for="products" class="col-xl-2 col-sm-12 col-form-label">
                        Product</label>
                    <select class="col-xl-7 col-sm-12"
                            name="products" id="products">
                        <c:forEach var="products" items="${requestScope.products}">
                            <option name="products" value="${products.id}"> ${products.id} ${products.name} ${products.count}
                                    ${products.price} ${products.categories} ${products.suppliers}
                                    ${products.localDate} ${products.date} ${products.shop} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row card-body" >
                    <label for="id" class="col-xl-2 col-sm-12 col-form-label">
                        Id</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="Enter name product" required>
                    </div>
                </div>

                <div class="form-group row card-body" >
                    <label for="name" class="col-xl-2 col-sm-12 col-form-label">
                        Name</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="Enter name product" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="count" class="col-xl-2 col-sm-12 col-form-label">
                        Count</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="count" id="count"
                               placeholder="Enter count" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="price" class="col-xl-2 col-sm-12 col-form-label">
                        Price</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="price" id="price"
                               placeholder="Enter price" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="categories_id" class="col-xl-2 col-sm-12 col-form-label">
                        Categories</label>
                    <select class="col-xl-7 col-sm-12"
                            name="categories_id" id="categories_id">
                        <c:forEach var="categories_id" items="${requestScope.categories}">
                            <option name="categories_id" value="${categories_id.id}" > ${categories_id.category} </option>
                        </c:forEach>
                    </select>


                </div>

                <div class="form-group row card-body" >
                    <label for="suppliers_id" class="col-xl-2 col-sm-12 col-form-label">
                        Suppliers</label>
                    <select class="col-xl-7 col-sm-12"
                            name="suppliers_id" id="suppliers_id">
                        <c:forEach var="suppliers_id" items="${requestScope.suppliers}">
                            <option name="suppliers_id" value="${suppliers_id.id}" >   ${suppliers_id.nameSupplier}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group row card-body" >
                    <label for="delivery" class="col-xl-2 col-sm-12 col-form-label">
                        Delivery</label>
                    <div class="col-xl-7 col-sm-12">
                        <input  type="date" pass="date" name="delivery" id="delivery"
                                placeholder="Enter delivery" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="date_expiration" class="col-xl-2 col-sm-12 col-form-label">
                        Date expiration</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="date"  pass="date" name="date_expiration" id="date_expiration"
                               placeholder="Enter date expiration" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="shop_id" class="col-xl-2 col-sm-12 col-form-label">
                        Shops</label>
                    <select class="col-xl-7 col-sm-12"
                            name="shop_id" id="shop_id">
                        <c:forEach var="shop_id" items="${requestScope.shops}">
                            <option name="shop_id" value="${shop_id.id}" >   ${shop_id.nameShop}</option>
                        </c:forEach>
                    </select>
                </div>



                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
    <ul>
        <a  type="submit" class="btn btn-primary" href="/accountant/update_all.jsp">EXIT</a>
    </ul>
</div>
</body>
</html>
