<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Current Store Profile</title>
</head>
<body>

<h3>Store name : ${sessionScope.currentUser.storeName}</h3>
<h3>Phone number : ${sessionScope.currentUser.storePhoneNumber}</h3>
<h3>Store adress : ${sessionScope.currentUser.storeAddress}</h3>
<h3>Acceptable payment methods : ${sessionScope.currentUser.paymentMethods}</h3>
<h3>Delivery methods : ${sessionScope.currentUser.deliveryMethods}</h3>
<h3>Product categories you sell : ${sessionScope.currentUser.productCategories}</h3>
<h3><a href="/store/storeProfileEdit">Edit profile info</a></h3>
<br>
<a href="/user/logout">Logout</a>
<br>
<br>
<a href="/pages/storeOffer/selectProductCategory.jsp">Create new offer</a>
<a href="/">Back to homepage</a>

<h3>Your offers : </h3>
<ul>
    <c:forEach var="offer" items="${listOfOffers}">
        <form action="/" method="post"> <!-- will be product page  -->
            <button name="id" value="${offer.id}"><img src="${offer.product.srcPicture}" class="block"
                                                       height="30" width="30" alt="...">
                Offer id = ${offer.id} , Description = ${offer.description}</button>
        </form>

        <form action="/offer/editOffer" method="get"> <!-- offerEdit page  -->
            <button name="id" value="${offer.id}">Edit offer</button>
        </form>

        <form action="/offer/deleteOffer"> <!-- offer deletion  -->
            <button name="id" value="${offer.id}">Delete offer</button>
        </form>
    </c:forEach>
</ul>

</body>
</html>