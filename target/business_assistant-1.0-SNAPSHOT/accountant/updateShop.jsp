<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Update shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1>Update shop</h1>

            <form action="/accountant/updateShop" method="post">
                <div class="form-group row card-body" >
                    <label for="shop_id" class="col-xl-2 col-sm-12 col-form-label">
                        Shops</label>
                    <select class="col-xl-7 col-sm-12"
                            name="shop_id" id="shop_id">
                        <c:forEach var="shop" items="${requestScope.shops}">
                            <option name="shop" value="${shop.id}" > ${shop.id}  ${shop.nameShop} ${shop.address}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group row card-body" >
                    <label for="id" class="col-xl-2 col-sm-12 col-form-label">
                        Id</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="Enter name" required>
                    </div>
                </div>

                <div class="form-group row card-body" >
                    <label for="nameShop" class="col-xl-2 col-sm-12 col-form-label">
                        Name</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="nameShop" id="nameShop"
                               placeholder="Enter name" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="address" class="col-2 col-form-label">
                        Address</label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="address" id="address"
                               placeholder="Enter address" required>
                    </div>
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

