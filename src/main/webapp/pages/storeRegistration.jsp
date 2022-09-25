<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.09.2022
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Store Registration</title>
</head>
<body>
<h2>Register your store in OnlinerStore!</h2>
<br>
<s:form action="/storeRegistration" method="post" modelAttribute="newStore">
    <p>Enter your e-mail:</p>
    <s:input path="email" size="30" placeholder="e-mail"/>
    <br>
    <s:errors path="email"/>
    <p>Enter your password:</p>
    <s:input path="password" size="30" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <p>Enter name of your store:</p>
    <s:input path="storeName" size="30" placeholder="Store name"/>
    <br>
    <s:errors path="storeName"/>
    <p>Enter address of your store:</p>
    <s:input path="storeAddress" size="30" placeholder="Store address"/>
    <br>
    <s:errors path="storeAddress"/>
    <p>Enter phone number of your store with +375:</p>
    <s:input path="storePhoneNumber" size="30" placeholder="Store phone number"/>
    <br>
    <s:errors path="storePhoneNumber"/>
    <p>Enter opening hours of your store:</p>
    <s:input path="storeOpeningHours" size="30" placeholder="Store opening hours"/>
    <br>
    <s:errors path="storeOpeningHours"/>
    <p>Enter store payer account number:</p>
    <s:input path="payerAccountNumber" size="30" placeholder="Store payer account number"/>
    <br>
    <s:errors path="payerAccountNumber"/>
    <p>Enter store registration certificate:</p>
    <s:input path="registrationCertificate" size="30" placeholder="Store registration certificate"/>
    <br>
    <s:errors path="registrationCertificate"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
