<%--
  Created by IntelliJ IDEA.
  User: ilya6
  Date: 06.10.2022
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer_personal_data</title>
</head>
<body>
<h2>Личные данные</h2>
<br>
<s:form action="/customer/personalData" method="post" modelAttribute="currentCustomer">
    <h1>Ник:     ${currentCustomer.nickname}</h1>
    <a href="${pageContext.request.contextPath}/customer/change/nickName">Изменить</a>
    <br>
    <h1>ФИО:     ${currentCustomer.firstname} ${currentCustomer.lastname} </h1>
    <a href="${pageContext.request.contextPath}/customer/change/fullName">Изменить</a>
    <br>
    <h1>Телефон: ${currentCustomer.telephone}</h1>
    <a href="${pageContext.request.contextPath}/customer/change/phoneNumber">Изменить</a>
    <br>
    <h1>E-mail:  ${currentCustomer.email}</h1>
</s:form>
</body>
</html>
