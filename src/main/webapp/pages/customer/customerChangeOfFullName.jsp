<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Customer FN change</title>
</head>
<body>
<h2>Enter new full name:</h2>
<br>
<s:form action="/customer/change/fullName" method="post" modelAttribute="currentCustomer">
  <p>Enter new firstname:</p>
  <s:input path="firstname" size="30" placeholder="First name"/>
  <br>
  <s:errors path="firstname"/>
  <p>Enter new lastname:</p>
  <s:input path="lastname" size="30" placeholder="Last name"/>
  <br>
  <s:errors path="lastname"/>
  <br>
  <s:button>Submit</s:button>
</s:form>
</body>
</html>
