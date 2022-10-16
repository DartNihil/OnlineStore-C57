<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 14.10.2022
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer_personal_data_UPD</title>
</head>
<body>
<h1>Изменение личных данных</h1>
<br>
<s:form action="/customer/personalData/update" method="post" modelAttribute="currentCustomer">
    <h3>Ник:</h3>
    <s:input path="nickname" size="30" value="${currentCustomer.nickname}" placeholder="Ник"/>
    <s:errors path="nickname"/>
    <br>
    <h3>ФИО:</h3>
    <h5>Имя</h5>
    <s:input path="firstname" size="30" value="${currentCustomer.firstname}" placeholder="Имя"/>
    <s:errors path="firstname"/>
    <h5>Фамилия</h5>
    <s:input path="lastname" size="30" value="${currentCustomer.lastname}" placeholder="Фамилия"/>
    <s:errors path="lastname"/>
    <br>
    <h3>Телефон:</h3>
    <s:input path="telephone" size="30" value="${currentCustomer.telephone}" placeholder="Телефон"/>
    <s:errors path="telephone"/>
    <br>
    <s:button>Сохранить</s:button>
</s:form>
</body>
</html>
