<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.10.2022
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select product</title>
</head>
<body>
<h2>Step 2: Select your notebook in OnlineStoreCatalog</h2>
<form action="/offer/addNotebook" method="post">
    <c:forEach items="${productList}" var="product">
        <input type="radio" name="id" value="${product.id}"><p><b>Product name:</b> ${product.productName}; <b>Producer:</b> ${product.producer};
        <b>Release date:</b> ${product.releaseDate}</p><br/>
    </c:forEach>
    <br>
    <button>Continue</button>
</form>
</body>
</html>
