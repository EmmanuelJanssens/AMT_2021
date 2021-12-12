<%--
  Created by IntelliJ IDEA.
  User: emman
  Date: 08/11/2021
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tag:layout>
    <jsp:attribute name="css">
<%--        all custom css for this page goes here--%>
        <%--        example: --%>
        <%--        <link rel="stylesheet" href="css_file">--%>
        <%--        <style>--%>
        <%--            h1 {--%>
        <%--                color: white;--%>
        <%--            }--%>
        <%--        </style>--%>


    </jsp:attribute>
    <jsp:attribute name="scripts">
<%--        all scripts that need to be place in head goes here--%>
        <%--        example: --%>
        <%--        <script src="js_file"></script>--%>
        <%--        <script>--%>
        <%--            console.log("my script example")--%>
        <%--        </script>--%>

    </jsp:attribute>
    <jsp:attribute name="bottomScrips">
    <%--        all scripts that need to be place in the bottom of body--%>
        <%--        example: --%>
        <%--        <script src="js_file"></script>--%>
        <%--        <script>--%>
        <%--            console.log("my script example")--%>
        <%--        </script>--%>
        <script>
            const alert = $("#descriptionExists")
            const description = $('#fruitDescription')
            const form = $("#addFruitForm")
            async function AddIfDescNotExist() {
                if (form.valid()) {
                    await $.get("${pageContext.request.contextPath}/fruits/description/" + description.val(), function (data) {
                        alert.text(data.name + " Has already the same description")
                        alert.addClass('alert alert-dark')
                    }).catch(e =>{
                        alert.removeClass('alert alert-dark')
                        alert.text("")
                        form.submit()
                    });
                }
            }
        </script>
    </jsp:attribute>
    <jsp:body>


        <div class="container">
            <div>
                <h5 d="addFruitTitle">Add a fruit</h5>
            </div>
            <form:form action="${pageContext.request.contextPath}/fruits/"
                       method="POST"
                       modelAttribute="fruit"
                       enctype="multipart/form-data"
                       id="addFruitForm"
                       class="well form-horizontal"
            >
                <!--TODO change to file-->
                <div class="form-group form-inline">
                    <form:label for="fruitName" class="col-md-4 control-label" path="image">Fruit Image</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:input type="file" class="form-control" id="fruitImage" aria-describedby="fruitImage"
                                        placeholder="Image" path="imageFile"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <form:label for="fruitName" class="col-md-4 control-label" path="name">Fruit name</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:input name="fruitName" placeholder="Name" class="form-control" type="text" path="name"
                                        required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <form:label for="fruitPrice" class="col-md-4 control-label" path="price">Fruit price</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:input name="fruitPrice" placeholder="price" class="form-control" type="text"
                                        path="price"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <form:label for="fruitAmount" class="col-md-4 control-label"
                                path="quantity">Fruit quantity</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:input name="fruitAmount" placeholder="Amount" class="form-control" type="text"
                                        path="quantity"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <form:label for="fruitDescription" class="col-md-4 control-label"
                                path="description">Fruit description</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:textarea name="fruitDescription" id="fruitDescription" placeholder="Description"
                                           class="form-control" type="text" path="description" required="true"/>
                        </div>
                        <p id="descriptionExists"></p>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <form:label for="fruitCategories" class="col-md-4 control-label"
                                path="categories">Fruit category</form:label>
                    <form:select
                            path="categories"
                            class="form-control"
                            id="fruitCategories"
                            items="${allFruitCategories}"
                            multiple="true"
                            aria-label="multiple select"
                    />
                </div>
                <div class="form-group form-inline">
                    <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn btn-secondary">Close</a>
                    <input type="button" id="addFruitBtn" class="btn btn-primary" onclick="AddIfDescNotExist()" value="Add"/>
                </div>
            </form:form>
        </div>

    </jsp:body>
</tag:layout>
