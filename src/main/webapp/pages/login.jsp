<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login into OnlinerStore</h2>
<br>
<s:form action="/login" method="post" modelAttribute="customer">
    <s:input path="name" size="50" placeholder="Name"/>
    <br>
    <s:errors path="name"/>
    <br>
    <s:input path="email" size="50" placeholder="Email"/>
     <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" size="50" placeholder ="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Login</s:button>

</s:form>

</body>
</html>
