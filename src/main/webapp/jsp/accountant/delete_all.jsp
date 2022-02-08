<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Delete</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel="stylesheet" href="../my_resourses/css/style_for_index.css">


</head>

<body>
<nav>
    <ul class="menu">
        <li><a href="deleteProduct"><fmt:message key="translation.delete_product"/></a></li>
        <li><a href="deleteCategories"><fmt:message key="translation.delete_categories"/></a></li>
        <li><a href="deleteShop"><fmt:message key="translation.delete_shop"/></a></li>
        <li><a href="deleteSupplier"><fmt:message key="translation.delete_suppliers"/></a></li>
        <li><a href="/accountant/accountant_menu.jsp"><fmt:message key="translation.exit"/></a></li>
    </ul>
</nav>
