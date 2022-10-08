<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Offer</title>
</head>
<body>
<h2>Edit offer</h2>
<s:form action="/offer/editOffer" method="post" modelAttribute="editedOffer">
  <p>Change your offer description:</p>
  <s:input path="description" size="30" placeholder="Description"/>
  <br>
  <s:errors path="description" cssStyle="color: red;"/>
  <br>
  <p>Change your offer price:</p>
  <s:input path="price" size="30" placeholder="Price"/> BYN</br>
  <br>
  <s:errors path="price" cssStyle="color: red"/>
  <br>
  <s:button name="id" value="${id}">Submit</s:button>
</s:form>
</body>
</html>
