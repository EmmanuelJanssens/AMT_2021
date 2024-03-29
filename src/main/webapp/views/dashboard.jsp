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


    </jsp:attribute>
    <jsp:body>

        <div id="fruits" class="section dark_bg layout_padding ">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading full text_align_center">
                            <h2 class="white_font full text_align_center">Our Fruits</h2>
                        </div>
                    </div>
                </div>
                <table class="table">
                    <thead>
                    <tr>
                        <th colspan="6">
                            <a href="${pageContext.request.contextPath}/admin/dashboard/add"  class="col-sm-12 btn btn-primary">
                                AddFruit</a>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">image</th>
                        <th scope="col">name</th>
                        <th scope="col">price</th>
                        <th scope="col">quantity</th>
                        <th scope="col">description</th>
                        <th scope="col">action</th>
                    </tr>
                    </thead>
                    <tbody id="fruits-body">


                        <%--@elvariable id="fruit" type="com.amt.mygarden.models.Fruit"--%>
                    <c:forEach var="fruit" items="${allFruits}">
                        <tr>
                            <td><img
                                    style="display: block"
                                    src="${pageContext.request.contextPath}/download/${fruit.image}" alt="image"
                                    width="10%"
                                    height="10%"
                            /> </td>
                            <td class="white_font"><strong>${fruit.name}</strong></td>
                            <td class="white_font">${fruit.price}</td>
                            <td class="white_font">${fruit.quantity}</td>
                            <td class="white_font">${fruit.description}</td>
                            <td>
                                <a href="${pageContext.request.contextPath }/admin/dashboard/delete/${fruit.name}" onclick="return confirm('Are you sure?')">Delete</a>
                            </td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>
    </jsp:body>
</tag:layout>


