<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List persons</title>
</head>
<body>
<p>
  <h1>

    <ul>

         <i>
                <c:forEach var="persons" items="${requestScope.person}">
                <option name="persons" value="${persons.id}" > ${persons.id}  ${persons.name}  ${persons.lastName}
                ${persons.telephoneNumber}  ${persons.role};</option>
                </c:forEach>

         </i>
    </ul>

  </h1>
</p>
</div>
<ul>
    <h1>
    <a  type="submit" class="active" href="/director/directors_work_page.jsp">EXIT
    </a>
    </h1>
</ul>
</div>
</body>
</html>
