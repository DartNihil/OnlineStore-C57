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
<body link="black">
<h2>Step 1: Select product category: </h2>
<br>
<c:forEach items="${sessionScope.currentUser.productCategories}" var="productCategory">
<ul>
<a href="/store/add${productCategory}">${productCategory}</a>
</ul>
</c:forEach>
</body>
</html>


