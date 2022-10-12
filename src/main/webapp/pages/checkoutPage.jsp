<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.10.2022
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
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
<div class="container mt-5 border border-dark">

    <div class="row border border-dark">

        <%--ToDo link to store page--%>

        <h2>${offerToCheckout.offer.store.storeName}</h2>
    </div>
    <div class="row">
        <div class="col border border-dark">

            <%--ToDo link to offer page--%>

            <h3>${offerToCheckout.offer.product.productName}</h3>
            <br>
            <input style="height: 30px" type="text" value="${offerToCheckout.count}" size="3"/>
            <br>
            <h3>${offerToCheckout.offer.price} BYN</h3>
        </div>
        <div class="col-sm-5 productDiv border border-dark">
            <img src="${offerToCheckout.offer.product.srcPicture}" alt="" height="90%"/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10 text-end">
            <h2>Total price:</h2>
        </div>
        <div class="col">
            <h2>${totalPrice} BYN</h2>
        </div>
    </div>
    <div class="row align-items-center border border-dark">
        <div class="col-sm-10 text-end">
            <form action="/offer/buy?offerId=${offerToCheckout.offer.id}" method="post">
                <button class="btn btn-success mt-3">Buy!</button>
            </form>
        </div>
        <div class="col text-end">
            <form action="/customer/cart" method="post">
                <button class="btn btn-secondary mt-3">Back to cart</button>
            </form>
        </div>
    </div>
</div>
<br>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
</body>
</html>
