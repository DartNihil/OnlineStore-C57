<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Offer</title>
</head>
<body>
<h2>Step 2: Enter smartphone's specifications!</h2>
<br>
<s:form action="/store/addSmartwatch" method="post" modelAttribute="newSmartwatch">
    <p>Add a link to your product image:</p>
    <s:input path="srcPicture" size="30" placeholder="srcPicture"/>
    <br>
    <s:errors path="srcPicture"/>
    <p>Enter name of your product:</p>
    <s:input path="productName" size="30" placeholder="Product name"/>
    <br>
    <s:errors path="productName"/>
    <p>Enter the producer of your product:</p>
    <s:input path="producer" size="30" placeholder="Producer"/>
    <br>
    <s:errors path="producer"/>
    <p>Enter release date of your product:</p>
    <s:input path="releaseDate" size="30" placeholder="Release date"/>
    <br>
    <s:errors path="releaseDate"/>
    <p>Enter screen size of your product:</p>
    <s:input path="screenSize" size="30" placeholder="Screen size"/>
    <br>
    <s:errors path="screenSize"/>
    <p>Enter color of your product:</p>
    <s:input path="color" size="30" placeholder="Color"/>
    <br>
    <s:errors path="color"/>
    <br>
    <p>Enter operating system of your product:</p>
    <s:input path="operatingSystem" size="30" placeholder="Operating system"/>
    <br>
    <s:errors path="operatingSystem"/>
    <br>
    <p>Enter battery capacity of your product:</p>
    <s:input path="batteryCapacity" size="30" placeholder="Battery capacity"/> mA*h</br>
    <br>
    <s:errors path="batteryCapacity"/>
    <br>
    <p>Enter bracelet material:</p>
    <s:input path="braceletMaterial" size="30" placeholder="Bracelet material"/>
    <br>
    <s:errors path="braceletMaterial"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>