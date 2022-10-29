<%--
  Created by IntelliJ IDEA.
  User: HomeUser
  Date: 04.10.2022
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CatalogSmartwatch</title>
</head>
<body>
<form action="/catalog/smartwatch">
    <button type="button" style="border: white; background: white; padding: 5px; width: 250px;" >
        <h1 style="font-size: 40px;">Onliner</h1>
    </button>
    <button style="float: right; padding: 10px; width: 150px; border: white; background: white;">
        Вход
    </button>
</form>
<div>
    <h1 style="font-size: 40px; padding: 10px">Умные часы</h1>
</div>
<div>
    <div style=" float: left; width: 250px; height: 400px; background-color: lightgrey; padding: 12px;">

    </div>
    <div style=" float: right; width: 1000px; height: 400px;  padding: 12px;">
        <c:forEach var="smartwatch" items="${smartwatchs}">
            <form action="/" method="post" >

                <button name="id"><img src="${smartwatch.product.srcPicture}" class="block"
                                       height="60" width="60" alt="...">
                        ${smartwatch.product.productName}, ${smartwatch.product.operatingSystem},
                        ${smartwatch.product.producer}
                </button>
            </form>
        </c:forEach>
    </div>
</div>

</body>
</html>
