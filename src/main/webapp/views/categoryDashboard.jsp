<%--
  Created by IntelliJ IDEA.
  User: ferra
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


    </jsp:attribute>
    <jsp:body>

        <div id="categories" class="section dark_bg layout_padding ">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading full text_align_center">
                            <h2 class="white_font full text_align_center">Our Categories</h2>
                        </div>
                    </div>
                </div>
                <table class="table">
                    <thead>
                    <tr>
                        <th colspan="6">
                            <a href="${pageContext.request.contextPath}/admin/categoryDashboard/add"  class="col-sm-12 btn-primary btn"type="button">
                                AddCategory</a>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">name</th>
                        <th scope="col">fruits</th>
                        <th scope="col">delete</th>
                    </tr>
                    </thead>
                    <tbody id="fruits-body">


                        <%--@elvariable id="category" type="com.amt.mygarden.models.Category"--%>
                    <c:forEach var="category" items="${allCategories}">
                        <tr>
                            <td class="white_font"><strong>${category.name}</strong></td>
                            <td class="white_font">
                                <c:forEach var="fruit" items="${category.fruits}">
                                    ${fruit.name},
                                </c:forEach>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath }:/admin/categoryDashboard/delete/${category.name}"
                                   onclick="return confirm('Are you sure?\nThe affected fruits will be :' +
                                           ' ${category.fruitsAsString}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>
    </jsp:body>
</tag:layout>


