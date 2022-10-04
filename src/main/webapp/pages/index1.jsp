<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 04.10.2022
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello Index1</p>
<c:forEach var="customer" items="${customers}">
    CustomerId<li>${customer.id}</li>
    CustomerFirstName<li>${customer}</li>
    CustomerLastName<li>${customer.lastname}</li>
    CustomerNickname<li>${customer.nickname}</li>
    CustomerPassword<li>${customer.password}</li>
    <a></a>
</c:forEach>
</body>
</html>
