<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Store Profile</title>
</head>
<body>

<h3>Store name : ${store.storeName}</h3>
<h3>Phone number : ${store.storePhoneNumber}</h3>
<h3>Store adress : ${store.storeAddress}</h3>
<h3>Acceptable payment methods : ${store.paymentMethods}</h3>
<h3>Delivery methods : ${store.deliveryMethods}</h3>
<h3>Product categories you sell : ${store.productCategories}</h3>
<br>
<a href="/">Back to homepage</a>

<h3>${store.storeName} offers : </h3>
<ul>
    <c:forEach var="offer" items="${listOfOffers}">
        <form action="/" method="post"> <!-- will be product page  -->
            <button name="id" value="${offer.id}"><img src="${offer.product.srcPicture}" class="block"
                                                       height="30" width="30" alt="...">
                Description = ${offer.description}</button>
        </form>
    </c:forEach>
</ul>

</body>
</html>
