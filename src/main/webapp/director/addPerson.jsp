<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Persons</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1>Add Person</h1>

            <form action="/director/addPerson" method="post">

                <div class="form-group row card-body" >
                    <label for="name" class="col-xl-2 col-sm-12 col-form-label">
                        Name</label>
                    <div class="col-xl-7 col-sm-12">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="Enter name" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="lastName" class="col-2 col-form-label">
                        Last name</label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="lastName" id="lastName"
                               placeholder="Enter last name" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="telephoneNumber" class="col-2 col-form-label">
                        Telephone</label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="telephoneNumber" id="telephoneNumber"
                               placeholder="Enter telephone" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="role_role" class="col-2 col-form-label">
                        Role</label>
                    <select class="col-7"
                       name="role" id="role_role">
                        <c:forEach var="role" items="${requestScope.role_role}">
                            <option name="role" value="${role.name()}" > ${role.name()}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
        <ul>
        <a  type="submit" class="active" href="/director/directors_work_page.jsp">Exit
        </a>
        </ul>
    </div>
</div>
</body>
</html>
