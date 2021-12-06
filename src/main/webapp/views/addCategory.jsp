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
            const alert = $("#exists")
            const form = $("#addCategoryForm")
            async function AddIfNameNotExist() {
                if (form.valid()) {
                    alert.removeClass('alert alert-dark')
                    alert.text("")
                    form.submit()
                    /*await $.get("${pageContext.request.contextPath}/category" + name, function (data) {
                        if (data.length > 0) {
                            alert.text(data[0].name + " Has already the same name")
                            alert.addClass('alert alert-dark')
                        } else {
                            alert.removeClass('alert alert-dark')
                            alert.text("")
                            form.submit()
                        }
                    });*/
                }
            }
        </script>
    </jsp:attribute>
    <jsp:body>


        <div class="container">
            <div>
                <h5 d="addCategoryTitle">Add a category</h5>
            </div>
            <form:form action="${pageContext.request.contextPath}/category/"
                       method="POST"
                       modelAttribute="category"
                       enctype="multipart/form-data"
                       id="addCategoryForm"
                       class="well form-horizontal"
            >
                <!--TODO change to file-->
                <div class="form-group form-inline">
                    <form:label for="categoryName" class="col-md-4 control-label" path="name">Category name</form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <form:input name="categoryName" placeholder="Name" class="form-control" type="text" path="name"
                                        required="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-inline">
                    <input type="button" class="btn btn-secondary" onclick="location.href='/categoryDashboard'" value="Close"/>
                    <input type="button" id="addCategoryBtn" class="btn btn-primary" onclick="AddIfNameNotExist()" value="Add"/>
                </div>
            </form:form>
        </div>

    </jsp:body>
</tag:layout>
