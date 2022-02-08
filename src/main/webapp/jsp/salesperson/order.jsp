<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Order</title>
</head>
<body>


<h1> <fmt:message key="translation.order#"/> ${requestScope.maxNumber} </h1>
    <p>
<c:forEach var="orders" items="${requestScope.orders}">
<c:if test="${orders.number==requestScope.maxNumber}">
      <ul>${orders.product}   - quantity - ${orders.quantum}  - price-  ${orders.priceFinal} - sum - ${orders.sum};</ul>
     <p>
      <ul> Shop - ${orders.nameShop}; Salesperson  - ${orders.nameSalesperson};</ul>
      <ul> </ul>
       <ul> ${orders.localDate} ; </ul>
     </p>
    </p>
    </c:if>
</c:forEach>
    <h4> Total amount - ${requestScope.sum}</h4>


<a  type="submit" class="button" href="/salesperson/addNullOrderServlet"><fmt:message key="translation.exit"/></a>

</body>
</html>
