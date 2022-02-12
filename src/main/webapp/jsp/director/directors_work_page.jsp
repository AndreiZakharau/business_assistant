<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>DIRECTOR'S WORK PAGE</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <link rel="stylesheet" href="../../my_resourses/css/style_for_index.css">


</head>

<body>
<nav>
    <ul class="menu">
        <li><a href="/director/addPerson"><fmt:message key="translation.director.addPerson"/></a></li>
        <li><a href="/director/updatePerson"><fmt:message key="translation.director.updatePerson"/></a></li>
        <li><a href="/director/deletePersonServlet"><fmt:message key="translation.director.deletePerson"/></a></li>
        <li><a href="/director/listPersonServlet"><fmt:message key="translation.director.listPerson"/></a></li>
        <li><a href="/jsp/director/director.jsp"><fmt:message key="translation.back"/></a></li>

    </ul>
</nav>


</body>
</html>
