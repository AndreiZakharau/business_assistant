<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Update suppliers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <div class="card">
        <div class="card-body">
            <h1><fmt:message key="translation.update_suppliers"/></h1>

            <form action="/accountant/updateSuppliers" method="post">

                <div class="form-group row card-body" >
                    <label for="suppliers_id" class="col-xl-2 col-sm-12 col-form-label">
                        <fmt:message key="translation.supplier"/></label>
                    <select class="col-xl-7 col-sm-12"
                            name="suppliers_id" id="suppliers_id">
                        <c:forEach var="suppliers_id" items="${requestScope.suppliers}">
                            <option name="suppliers_id" value="${suppliers_id.id}" > ${suppliers_id.id}  ${suppliers_id.nameSupplier}
                                    ${suppliers_id.contactTel} ${suppliers_id.email}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row card-body">
                    <label for="id" class="col-2 col-form-label">
                        <fmt:message key="translation.id"/></label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="id" id="id"
                               placeholder="<fmt:message key="translation.ed"/>" required>
                    </div>
                </div>
                <div class="form-group row card-body">
                    <label for="name" class="col-2 col-form-label">
                        <fmt:message key="translation.name"/></label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="<fmt:message key="translation.message.name"/>" required>
                    </div>
                </div>

                <div class="form-group row card-body">
                    <label for="contact_tel" class="col-2 col-form-label">
                        <fmt:message key="translation.phone"/></label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="contact_tel" id="contact_tel"
                               placeholder="<fmt:message key="translation.message.phone"/>" required>
                    </div>
                </div>
                <div class="form-group row card-body">
                    <label for="email" class="col-2 col-form-label">
                        Email</label>
                    <div class="col-7">
                        <input type="text" class="form-control" name="email" id="email"
                               placeholder="<fmt:message key="translation.message.email"/>">
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
