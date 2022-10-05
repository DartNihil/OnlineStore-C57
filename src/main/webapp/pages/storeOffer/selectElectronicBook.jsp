<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.10.2022
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select product</title>
</head>
<body>
<p>Select your electronic book in OnlineStoreCatalog</p>
<form action="/offer/addElectronicBook" method="post">
    <c:forEach items="${productList}" var="product">
        <input type="radio" name="newElectronicBook" value="${product}">${product}<br/>
    </c:forEach>
    <br>
    <button>Continue</button>
</form>
</body>
</html>