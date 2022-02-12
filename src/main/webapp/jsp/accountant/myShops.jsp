<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Shops</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1><fmt:message key="translation.shop"/></h1>

            <form action="/accountant/addShop" method="post">

                <div class="form-group row card-body" >
                    <label for="nameShop" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.name"/></label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="nameShop" id="nameShop"
                               placeholder="<fmt:message key="translation.message.enter_shop_name"/>" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="address" class="col-2 col-form-label">
                        <fmt:message key="translation.address"/></label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="address" id="address"
                               placeholder="<fmt:message key="translation.message.address"/>" required>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary"><fmt:message key="translation.button.save"/></button>
            </form>
        </div>
    </div>
    <ul>
        <a  type="submit" class="btn btn-primary" href="/jsp/accountant/add_all.jsp"><fmt:message key="translation.button.exit"/></a>
    </ul>
</div>
</body>
</html>
