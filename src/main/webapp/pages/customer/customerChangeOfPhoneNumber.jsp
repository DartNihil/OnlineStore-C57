<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer PN change</title>
</head>
<body>
<br>
<s:form action="/customer/change/phoneNumber" method="post" modelAttribute="currentCustomer">
    <p>Enter new telephone number:</p>
    <s:input path="telephone" size="30" placeholder="New telephone"/>
    <br>
    <s:errors path="telephone"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>