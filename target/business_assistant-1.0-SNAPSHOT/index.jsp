<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="my_resourses/css/style_for_index.css">

</head>
<%@ include file="jsp/locale.jsp" %>
<body>

<ul class="menu">

    <li><a href="enterServlet"><fmt:message key="translation.index.enter"/></a></li>
    <li><a href="jsp/page_expected.jsp"><fmt:message key="translation.index.go_shopping"/></a></li>
    <li><a href="jsp/page_expected.jsp"><fmt:message key="translation.index.contact"/></a></li>
    <li><a href="loginServlet"><fmt:message key="translation.index.for_director"/></a></li>

</ul>

</body>

</html>
