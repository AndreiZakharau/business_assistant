<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Full Screen Nav</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../../my_resourses/css/accontant_menu.css">

</head>

<body>

<div id="nav-trigger" class="nav-trigger open">
    <span class="line"></span>
    <span class="line"></span>
    <span class="line"></span>
</div>
<nav id="nav" class="out">
    <ul>
        <li><a class="nav-label" href="/jsp/accountant/add_all.jsp"><fmt:message key="translation.add"/></a></li>
        <li><a class="nav-label" href="/jsp/accountant/update_all.jsp"><fmt:message key="translation.update"/></a></li>
        <li><a class="nav-label" href="/jsp/accountant/delete_all.jsp"><fmt:message key="translation.delete"/></a></li>
        <li><a class="nav-label" href="/jsp/accountant/pege_expected_accountant.jsp"><fmt:message key="translation.application"/></a></li>
        <li><a class="nav-label" href="/accountant/listWork"><fmt:message key="translation.list_info"/></a></li>
        <li><a class="nav-label" href="/index.jsp"><fmt:message key="translation.exit"/></a></li>
    </ul>
</nav>
<section id="header" class="header">
    <h1 id="heading"></h1>
</section>


<script src="/my_resourses/js/accountant_menu.js"></script>

</body>
</html>

