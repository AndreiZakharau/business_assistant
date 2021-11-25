
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>WELCOME</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:300,400,700'>

    <link rel="stylesheet" href="my_resourses/css/style_for_regisration.css">


</head>

<body>

<div class="container">
    <div class="front side">
        <div class="content">
            <h1>GOREVOY SERGEY</h1>
            <p>
            </p>
        </div>
    </div>
    <div class="back side">
        <div class="content">
            <h1>Enter</h1>
            <form action="loginServlet" method="post">
                <label for="login">Your login :</label>
                <input type="text" class="form-control" name="login" id="login" placeholder="Enter your login">
                <label for="password">Your password :</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="enter your password" >
                <input type="submit" value="Enter" href="loginServlet">
            </form>
        </div>
    </div>

</div>


</body>
</html>

