<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Homepage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<h2>ONLINER</h2>

<form action="/" method="post">
    <input type="text" name="searchProduct" size="100" placeholder="catalog search">
    <button>Submit</button>
</form>
<c:if test="${sessionScope.currentCustomer == null && sessionScope.currentStore == null}">
    <form action="/user/login">
        <button>Login</button>
    </form>
</c:if>


<c:if test="${sessionScope.currentCustomer != null}">

    <br>
    <form action="/customer/cart" method="post">
        <c:if test="${sessionScope.currentCustomer.cart.size() == 0}">
            <button class="btn btn-secondary">My cart</button>
        </c:if>
        <c:if test="${sessionScope.currentCustomer.cart.size() != 0}">
            <button class="btn btn-danger">My cart (${currentCustomer.getCountOffersInCart()})</button>
        </c:if>
    </form>
</c:if>

<form action="/catalog/mobile" method="get">
    <button>Smartphone</button>
</form>

<form action="/catalog/ebook" method="get">
    <button>ElectronicBooks</button>
</form>

<form action="/catalog/tablet" method="get">
    <button>Tablet</button>
</form>

<form action="/catalog/notebook" method="get">
    <button>Notebooks</button>
</form>

<form action="/catalog/smartwatch" method="get">
    <button>Smartwatch</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
