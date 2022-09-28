<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login into OnlinerStore</h2>
<br>
<s:form action="/login" method="post" modelAttribute="user">
    <s:input path="email" size="50" placeholder="Email"/>
    <br>
    <s:errors path="email" cssStyle="color: red"/>
    <br>
    <s:input path="password" size="50" placeholder="Password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <s:button>Login</s:button>
</s:form>
<p style="color: red">${message}</p>

<h3>Not registered yet?</h3>
<a href="/storeRegistration">Register as a Store</a>
<!-- Link to customer registration -->
<a href="">Register as a Customer</a>

</body>
</html>