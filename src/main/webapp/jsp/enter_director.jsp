<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>WELCOME</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:300,400,700'>

    <link rel="stylesheet" href="../my_resourses/css/style_for_regisration.css">


</head>

<body>

<div class="container">
    <div class="front side">
        <div class="content">
            <h1><fmt:message key="translation.director.director"/></h1>
            <p>
            </p>
        </div>
    </div>
    <div class="back side">
        <div class="content">
            <h1><fmt:message key="translation.index.enter"/> </h1>
            <form action="loginServlet" method="post">
                <label for="login"><fmt:message key="translation.director.login"/> :</label>
                <input type="text" class="form-control" name="login" id="login" placeholder="<fmt:message key="translation.director.message.login"/>">
                <label for="password"><fmt:message key="translation.director.password"/> :</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="<fmt:message key="translation.director.message.password"/>">
                <input type="submit" value="Enter" href="loginServlet">
            </form>
        </div>
    </div>

</div>


</body>
</html>

