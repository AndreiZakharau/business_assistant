<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Update categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1><fmt:message key="translation.update_categories"/></h1>

            <form action="/accountant/updateCategories" method="post">

                <div class="form-group row card-body" >
                    <label for="categories" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.category"/></label>
                    <select class="col-xl-7 col-sm-12"
                           name="categories" id ="categories">
                        <c:forEach var="categories" items="${requestScope.categories}">
                            <option name="categories" value="${categories.id}" > ${categories.id} ${categories.category} ${categories.interest} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row card-body" >
                    <label for="id" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.id"/></label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="<fmt:message key="translation.ed"/>" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="name" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.categoriesName"/></label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="<fmt:message key="translation.message.categories"/>" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                <label for="interest" class="col-xl-2 col-sm-12 col-form-label">
                    <fmt:message key="translation.interest"/></label>
                <div class="col-xl-7 col-sm-12">
                    <input type="text" class="form-control" name="interest" id="interest"
                           placeholder="<fmt:message key="translation.message.%"/>" required>
                </div>
                </div>





                <button type="submit" class="btn btn-primary"><fmt:message key="translation.button.save"/></button>
            </form>
        </div>
    </div>
    <ul>
        <a  type="submit" class="btn btn-primary" href="/jsp/accountant/update_all.jsp"><fmt:message key="translation.exit"/></a>
    </ul>
</div>
</body>
</html>
