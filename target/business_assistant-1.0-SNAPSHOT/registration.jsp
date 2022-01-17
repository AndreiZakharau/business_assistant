<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>

    <title>Entrance for work</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:300,400,700'>

    <link rel="stylesheet" href="my_resourses/css/style_for_regisration.css">


</head>

<body>

<div class="container">
    <div class="front side">
        <div class="content">
            <h1><fmt:message key="translation.regisration.entrance_for_work"/></h1>
            <p>
            </p>
        </div>
    </div>
    <div class="back side">
        <div class="content">
            <h1><fmt:message key="translation.registration.contact_me"/></h1>
            <form action="enterServlet" method="post">

                <label for="name"><fmt:message key="translation.registration.name"/> :</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="<fmt:message key="translation.registration.message.name"/>"/>
                <label for="lastName"><fmt:message key="translation.registration.surname"/> :</label>
                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="<fmt:message key="translation.registration.message.surname"/>">
                <label for="telephoneNumber"><fmt:message key="translation.registration.phone"/> :</label>
                <input type="text" class="form-control" name="telephoneNumber" id="telephoneNumber"  placeholder="<fmt:message key="translation.registration.message.phone"/>">
                <input type="submit" value="Enter" href="enterServlet">
            </form>
        </div>
    </div>

</div>


</body>
</html>
