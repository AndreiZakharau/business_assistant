<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

  <title>Director menu</title>

  <title>Full Screen Nav</title>
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


  <link rel="stylesheet" href="/my_resourses/css/accontant_menu.css">


</head>

<body>
<div id="nav-trigger" class="nav-trigger open">
  <span class="line"></span>
  <span class="line"></span>
  <span class="line"></span>
</div>

<nav id="nav" class="out">
  <ul>
    <li><a class="nav-label" href="/jsp/director/directors_work_page.jsp"><fmt:message key="translation.work"/> </a></li>
    <li><a class="nav-label" href="/director/listPersonServlet"><fmt:message key="translation.persons"/></a></li>
    <li><a class="nav-label" href="/jsp/director/page_expected_director.jsp"><fmt:message key="translation.statistic"/></a></li>
    <li><a class="nav-label" href="/jsp/director/page_expected_director.jsp"><fmt:message key="translation.application"/></a></li>
    <li><a class="nav-label" href="/director/listWorkServlet"><fmt:message key="translation.list_info"/></a></li>
    <li><a class="nav-label" href="/index.jsp"><fmt:message key="translation.exit"/></a></li>
  </ul>
</nav>
<section id="header" class="header">
  <h1 id="heading"></h1>
</section>


<script  src="/my_resourses/js/accountant_menu.js"></script>

</body>
</html>
