<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 26.09.2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Registration</title>
</head>
<body>
<h2>Register customer in OnlineStore!</h2>
<br>
<br>
<s:form action="/storeRegistration" method="post" modelAttribute="newStore">
  <p>Enter your nickname:</p>
  <s:input path="nickname" size="30" placeholder="Nickname"/>
  <br>
  <s:errors path="nickname"/>
  <p>Enter your firstname:</p>
  <s:input path="firstname" size="30" placeholder="First name"/>
  <br>
  <s:errors path="firstname"/>
  <p>Enter your lastname:</p>
  <s:input path="lastname" size="30" placeholder="Last name"/>
  <br>
  <s:errors path="lastname"/>
  <p>Enter your e-mail:</p>
  <s:input path="email" size="30" placeholder="e-mail"/>
  <br>
  <s:errors path="email"/>
  <p>Enter your password:</p>
  <s:input path="password" size="30" type="password" placeholder="Password"/>
  <br>
  <s:errors path="password"/>
  <br>
  <s:button>Submit</s:button>
</s:form>
</body>
</html>