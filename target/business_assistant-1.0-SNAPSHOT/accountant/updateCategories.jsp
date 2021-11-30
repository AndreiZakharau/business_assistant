<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1>Update categories</h1>

            <form action="/accountant/updateCategories" method="post">

                <div class="form-group row card-body" >
                    <label for="categories" class="col-xl-2 col-sm-12 col-form-label">
                        Categories</label>
                    <select class="col-xl-7 col-sm-12"
                           name="categories" id ="categories">
                        <c:forEach var="categories" items="${requestScope.categories}">
                            <option name="categories" value="${categories.id}" > ${categories.id} ${categories.category} ${categories.interest} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row card-body" >
                    <label for="id" class="col-xl-2 col-sm-12 col-form-label">
                        Id</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="Enter categories id" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                    <label for="name" class="col-xl-2 col-sm-12 col-form-label">
                        Name categories</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="Enter categories" required>
                    </div>
                </div>
                <div class="form-group row card-body" >
                <label for="interest" class="col-xl-2 col-sm-12 col-form-label">
                    Interest</label>
                <div class="col-xl-7 col-sm-12">
                    <input type="text" class="form-control" name="interest" id="interest"
                           placeholder="Enter interest %" required>
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