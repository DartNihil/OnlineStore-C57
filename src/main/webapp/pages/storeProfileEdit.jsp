<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Store Profile Edit</title>
</head>
<body>
<h3>Edit your store profile</h3>
<s:form action="/store/storeProfileEdit" method="post" modelAttribute="editedStore">
    <p>Change name of your store:</p>
    <s:input path="storeName" size="30" placeholder="Store name"/>
    <br>
    <s:errors path="storeName" cssStyle="color: red"/>
    <p>Change address of your store:</p>
    <s:input path="storeAddress" size="30" placeholder="Store address"/>
    <br>
    <s:errors path="storeAddress" cssStyle="color: red"/>
    <p>Change phone number of your store with +375:</p>
    <s:input path="storePhoneNumber" size="30" placeholder="Store phone number"/>
    <br>
    <s:errors path="storePhoneNumber" cssStyle="color: red"/>
    <p>Change opening hours of your store:</p>
    <s:input path="storeOpeningHours" size="30" placeholder="Store opening hours"/>
    <br>
    <s:errors path="storeOpeningHours" cssStyle="color: red"/>
    <br>
    <p>Change product categories you want to sell:</p>
    <s:checkbox path="productCategories" value="Smartphone"/>Smartphone<br/>
    <s:checkbox path="productCategories" value="Notebook"/>Notebook<br/>
    <s:checkbox path="productCategories" value="ElectronicBook"/>ElectronicBook<br/>
    <s:checkbox path="productCategories" value="Smartwatch"/>Smartwatch<br/>
    <s:checkbox path="productCategories" value="Tablet"/>Tablet<br/>
    <br>
    <p>Change possible payment methods:</p>
    <s:checkbox path="paymentMethods" value="OnlinePay"/>Online Pay<br/>
    <s:checkbox path="paymentMethods" value="CardPay"/>Card Pay<br/>
    <s:checkbox path="paymentMethods" value="CashPay"/>Cash Pay<br/>
    <br>
    <p>Change possible delivery methods:</p>
    <s:checkbox path="deliveryMethods" value="Self-pickup"/>Self-pickup<br/>
    <s:checkbox path="deliveryMethods" value="Courier delivery"/>Courier delivery<br/>
    <s:checkbox path="deliveryMethods" value="Mail delivery"/>Mail delivery<br/>
    <s:button>Submit</s:button>
</s:form>
<a href="/store/currentStoreProfile">Back to profile</a>

</body>
</html>