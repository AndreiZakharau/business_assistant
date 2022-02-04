<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="my_resourses/css/button.css">


<c:set var="language"
       value="${not empty param.language ? param.language : not empty sessionScope.lang ? sessionScope.lang : 'en_US'}"
       scope="session"/>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.translation" scope="session"/>


<div>
  <form action="${pageContext.request.contextPath}/locale" method="post">
      <button class="button" type="submit" name="lang" value="ru_RU">Русский</button>
      <button class="button" type="submit" name="lang" value="en_US">English</button>
  </form>
</div>

