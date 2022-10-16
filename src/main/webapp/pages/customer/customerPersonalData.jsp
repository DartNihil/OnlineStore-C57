<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 13.10.2022
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer_personal_data</title>
</head>
<body>
<h1>Личные данные</h1>
<br>
<s:form action="/customer/personalData" method="post" modelAttribute="currentCustomer">
    <h3>Ник:     ${currentCustomer.nickname}</h3>
    <h3>ФИО:     ${currentCustomer.firstname} ${currentCustomer.lastname} </h3>
    <h3>Телефон: ${currentCustomer.telephone}</h3>
    <h3>E-mail:  ${currentCustomer.email}</h3>
    <br>
    <s:button>Редактировать личные данные</s:button>
</s:form>
</body>
</html>
