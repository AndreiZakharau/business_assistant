<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <title>Menu</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <link rel="stylesheet" href="/my_resourses/css/style_for_index.css">


</head>

<body>


<nav>

    <ul class="menu">
        <li><a href="/salesperson/salespersonWork"><fmt:message key="translation.work"/></a></li>
        <li><a href="/salesperson/pege_exp.jsp "><fmt:message key="translation.statistic"/></a></li>
        <li><a href="/index.jsp"><fmt:message key="translation.exit"/></a></li>

    </ul>
</nav>


</body>
</html>