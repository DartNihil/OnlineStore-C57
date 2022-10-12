<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <style>
        .productDiv {
            min-height: 250px;
            position: relative
        }

        .productDiv img {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: 0 -50% 0 0;
            transform: translate(-50%, -50%)
        }

        #offerToBuy {
            transform: scale(1.3);
            opacity: 0.9;
            cursor: pointer;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:if test="${currentCustomer.cart.size() == 0}">
    <h1>Your cart is empty!</h1>
</c:if>
<c:if test="${currentCustomer.cart.size() != 0}">
    <div class="container mt-5 border border-dark">
        <c:forEach items="${cartList}" var="offerInCart">
            <div class="row border border-dark">

                    <%--ToDo link to store page--%>

                <h2>${offerInCart.offer.store.storeName}</h2>
            </div>
            <div class="row">
                <div class="col border border-dark">

                        <%--ToDo link to offer page--%>

                    <h3>${offerInCart.offer.product.productName}</h3>
                    <br>
                    <div class="btn-group">
                        <form action="/offer/minusOffer?offerId=${offerInCart.offer.id}" method="post">
                            <button style="height: 30px" class="minus">-</button>
                        </form>
                        <input style="height: 30px" type="text" value="${offerInCart.count}" size="3"/>
                        <form action="/offer/plusOffer?offerId=${offerInCart.offer.id}" method="post">
                            <button style="height: 30px" class="plus">+</button>
                        </form>
                    </div>
                    <br>
                    <h3>${offerInCart.offer.price} BYN</h3>
                </div>
                <div class="col-sm-5 productDiv border border-dark">
                    <img src="${offerInCart.offer.product.srcPicture}" alt="" height="90%"/>
                </div>
            </div>
            <div class="row align-items-center border border-dark">
                <div class="col-sm-11 text-end">
                    <form action="/offer/checkout?offerId=${offerInCart.offer.id}" method="post">
                        <button class="btn btn-success mt-3">Go to checkout</button>
                    </form>
                </div>
                <div class="col text-end">
                    <form action="/offer/deleteFromCart?offerId=${offerInCart.offer.id}" method="post">
                        <button class="btn btn-danger mt-3">Delete</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="container mt-5 border border-dark">
        <div class="row">
            <div class="col-sm-10 text-end">
                <h2>Total price:</h2>
            </div>
            <div class="col">
                <h2>${totalPrice} BYN</h2>
            </div>
        </div>
    </div>
    <br>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
