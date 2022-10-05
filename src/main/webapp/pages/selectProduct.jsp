<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.10.2022
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select product</title>
</head>
<body>
<c:forEach items="${productList}" var="product">
    <p>${product}</p>
</c:forEach>
<form action="/offer/addProduct" method="post">
    <button>Submit</button>
</form>
</body>
</html>
