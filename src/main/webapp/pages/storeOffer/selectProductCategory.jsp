<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.09.2022
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select product category</title>
</head>
<body>
<h2>Step 1: Select product category: </h2>
<br>
<form action="/offer/selectProductCategory" method="post">
    <c:forEach items="${sessionScope.currentStore.productCategories}" var="productCategory">
        <input id="radioId" type="radio" name="productCategory" value="${productCategory}">
        <label for="radioId">${productCategory}</label>
        <br>
    </c:forEach>
    <br>
    <button>Continue</button>
</form>
</body>
</html>


