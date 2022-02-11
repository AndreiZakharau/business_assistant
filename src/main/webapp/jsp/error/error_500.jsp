<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="/my_resourses/css/error_style.css">
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<div>
    <img src="http://hoffmander.com/images/travolta-gif-repeat.gif" alt="travolta">
</div>
<p>Type: <%=pageContext.getException().getClass().toString()%></p>
<p>Message: <%=pageContext.getException().getMessage()%></p>
</body>
</html>
