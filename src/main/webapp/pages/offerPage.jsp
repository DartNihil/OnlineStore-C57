<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.09.2022
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--!!! Page for test! Will be created in INST-10! !!!--%>

<html>
<head>
    <title>Offer page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<%--Test part--%>

<br>
<p>offer1</p>
<form action="/offer/addOfferToCart?offerId=1"
      method="post"> <%--offerId will be changed for ${}, 1 used like example  --%>
    <button>Add to cart</button>
</form>
<br>
<p>offer2</p>
<form action="/offer/addOfferToCart?offerId=2"
      method="post"> <%--offerId will be changed for ${}, 2 used like example  --%>
    <button>Add to cart</button>
</form>
<br>
<p>offer3</p>
<form action="/offer/addOfferToCart?offerId=3"
      method="post"> <%--offerId will be changed for ${}, 3 used like example  --%>
    <button>Add to cart</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
