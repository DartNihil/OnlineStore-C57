<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>

<h2>ONLINER</h2>

<form action="/" method="post">
    <input type="text" name="searchProduct" size="100" placeholder="catalog search">
    <button>Submit</button>
</form>

<form action="/login" method="get">
    <button>Login</button>
</form>

<form action="/basket" method="get">
    <button>Basket of products</button>
</form>

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
</body>
</html>