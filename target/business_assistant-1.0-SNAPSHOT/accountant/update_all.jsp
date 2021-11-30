<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Update</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel="stylesheet" href="../my_resourses/css/style_for_index.css">


</head>

<body>
<nav>
    <ul class="menu">
        <li><a href="updateProduct"><fmt:message key="translation.update_product"/></a></li>
        <li><a href="updateCategories"><fmt:message key="translation.update_categories"/></a></li>
        <li><a href="updateShop"><fmt:message key="translation.update_shop"/></a></li>
        <li><a href="updateSuppliers"><fmt:message key="translation.update_suppliers"/></a></li>
        <li><a href="/accountant/accountant_menu.jsp"><fmt:message key="translation.exit"/></a></li>
    </ul>
</nav>


</body>
</html>
