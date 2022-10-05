<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Offer</title>
</head>
<body>
<h2>Step 3: create your offer in OnlineStore!</h2>
<br>
<s:form action="/store/createOffer" method="post" modelAttribute="OfferDTO">
    <p>Enter your offer description:</p>
    <s:input path="description" size="30" placeholder="Description"/>
    <br>
    <s:errors path="description"/>
    <br>
    <p>Enter your offer price:</p>
    <s:input path="price" size="30" placeholder="Price"/> BYN</br>
    <br>
    <s:errors path="price"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>