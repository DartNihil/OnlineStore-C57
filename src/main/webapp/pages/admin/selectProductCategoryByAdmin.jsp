<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.10.2022
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select product category</title>
</head>
<body>
<form action="/admin/selectProductCategory" method="post">
    <input id="spId" type="radio" name="productCategory" value="Smartphone">
    <label for="spId">Smartphone</label>
    <br>
    <input id="ebId" type="radio" name="productCategory" value="ElectronicBook">
    <label for="ebId">ElectronicBook</label>
    <br>
    <input id="swId" type="radio" name="productCategory" value="Smartwatch">
    <label for="swId">Smartwatch</label>
    <br>
    <input id="nbId" type="radio" name="productCategory" value="Notebook">
    <label for="nbId">Notebook</label>
    <br>
    <input id="tblId" type="radio" name="productCategory" value="Tablet">
    <label for="tblId">Tablet</label>
    <br>
    <button>Continue</button>
</form>

</body>
</html>
