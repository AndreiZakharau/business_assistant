
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
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
        <li><a class="nav-label" href="/accountant/add_all.jsp">Add</a></li>
        <li><a class="nav-label" href="/accountant/update_all.jsp">Update</a></li>
        <li><a class="nav-label" href="/accountant/delete_all.jsp">Delete</a></li>
        <li><a class="nav-label" href="">Application</a></li>
        <li><a class="nav-label" href="/accountant/listWork">List info</a></li>
        <li><a class="nav-label" href="/index.jsp">Exit</a></li>
    </ul>
</nav>
<section id="header" class="header">
    <h1 id="heading"></h1>
</section>


<script  src="/my_resourses/js/accountant_menu.js"></script>

</body>
</html>

