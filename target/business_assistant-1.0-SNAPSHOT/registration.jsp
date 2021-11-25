<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
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
            <h1>ENTRANCE FOR WORK</h1>
            <p>
            </p>
        </div>
    </div>
    <div class="back side">
        <div class="content">
            <h1>Contact Me</h1>
            <form action="enterServlet" method="post">

                <label for="name">Your Name :</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter your name">
                <label for="lastName">Your Last name :</label>
                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter your last name">
                <label for="telephoneNumber">Your telephone number :</label>
                <input type="text" class="form-control" name="telephoneNumber" id="telephoneNumber"  placeholder="enter your telephone number (+375.........)">
                <input type="submit" value="Enter" href="enterServlet">
            </form>
        </div>
    </div>

</div>


</body>
</html>
