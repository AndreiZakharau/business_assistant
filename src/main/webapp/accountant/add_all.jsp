<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Accountant star</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <link rel="stylesheet" href="../my_resourses/css/style_for_index.css">


</head>

<body>
<nav>
    <ul class="menu">
        <li><a href="addProduct"><fmt:message key="translation.addProduct"/></a></li>
        <li><a href="addCategories"><fmt:message key="translation.addCategories"/></a></li>
        <li><a href="addShop"><fmt:message key="translation.add_shop"/></a></li>
        <li><a href="addSuppliers"><fmt:message key="translation.add_suppliers"/></a></li>
        <li><a href="/accountant/accountant_menu.jsp"><fmt:message key="translation.exit"/></a></li>


    </ul>
</nav>


</body>
</html>