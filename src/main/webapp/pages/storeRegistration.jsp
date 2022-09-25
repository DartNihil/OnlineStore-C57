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
<s:form action="/registration" method="post" modelAttribute="newStore">
    <s:input path="firstName" placeholder="First name"/>
    <br>
    <s:errors path="firstName"/>
    <br>
    <s:input path="secondName" placeholder="Second name"/>
    <br>
    <s:errors path="secondName"/>
    <br>
    <s:input path="email" placeholder="E-mail"/>
    <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
