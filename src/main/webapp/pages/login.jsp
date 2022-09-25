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
<s:form action="/login" method="post">
    <s:input path="email" size="50" placeholder="e-mail"/>
     <br>
    <s:input path="password" size="50" placeholder ="password"/>
    <br>
    <s:button>Login</s:button>

</s:form>

</body>
</html>
