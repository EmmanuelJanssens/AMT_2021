<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Fruit</title>
</head>
<body>
<%--@elvariable id="fruit" type="com.amt.mygarden.models.Fruit"--%>
<form:form action="${pageContext.request.contextPath}/{id}" method="POST" enctype="multipart/form-data">
    <div class="form-group">
    <form:label for="fruitAmount" path="quantity">Fruit quantity</form:label>
    <form:input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" required="true" path="quantity"/>
    </div>
    <div class="modal-footer">
    <button type="submit" class="btn btn-primary">Add</button>
    </div>
</form:form>
</body>
</html>
