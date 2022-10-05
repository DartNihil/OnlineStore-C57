<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.10.2022
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Select product</title>
</head>
<body>
<h2>Step 2: Select your smartphone in OnlineStoreCatalog</h2>
<form action="/offer/addSmartphone" method="post">
    <c:forEach items="${productList}" var="product">
        <input type="radio" name="id" value="${product.id}">${product}<br/>
    </c:forEach>
    <br>
    <button>Continue</button>
</form>
</body>
</html>
