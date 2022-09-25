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
<s:form action="/storeRegistration" method="post" modelAttribute="newStore">
    <s:input path="email" placeholder="E-mail"/>
    <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:input path="storeName" placeholder="Store name"/>
    <br>
    <s:errors path="storeName"/>
    <br>
    <s:input path="storeAddress" placeholder="Store address"/>
    <br>
    <s:errors path="storeAddress"/>
    <br>
    <s:input path="storePhoneNumber" placeholder="Store phone number"/>
    <br>
    <s:errors path="storePhoneNumber"/>
    <br>
    <s:input path="storeOpeningHours" placeholder="Store opening hours"/>
    <br>
    <s:errors path="storeOpeningHours"/>
    <br>
    <s:input path="payerAccountNumber" placeholder="Store payer account number"/>
    <br>
    <s:errors path="payerAccountNumber"/>
    <br>
    <s:input path="registrationCertificate" placeholder="Store registration certificate"/>
    <br>
    <s:errors path="registrationCertificate"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
