<%--
  Created by IntelliJ IDEA.
  User: manuc
  Date: 13/11/2021
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tag:layout>
<jsp:body>
    <div id="cart" class="section dark_bg layout_padding ">
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
                <th scope="col">name</th>
                <th scope="col">price</th>
                <th scope="col">quantity</th>
            </tr>
            </thead>
            <tbody>


            <%--@elvariable id="item" type="com.amt.mygarden.models.Item"--%>
            <c:forEach  items="${allItems}" var="item">
                <tr>
                    <td class="white_font"><strong>${item.fruit.name}</strong></td>
                    <td class="white_font">${item.fruit.price}</td>
                    <td class="white_font">${item.quantity}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 </div>

</jsp:body>
</tag:layout>