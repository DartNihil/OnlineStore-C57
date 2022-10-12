<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer NN change</title>
</head>
<body>
<br>
<s:form action="/customer/change/nickName" method="post" modelAttribute="currentCustomer">
    <p>Enter new nickname:</p>
    <s:input path="nickname" size="30" placeholder="New nickname"/>
    <br>
    <s:errors path="nickname"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
