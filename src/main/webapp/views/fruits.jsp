<%@ page import="com.amt.mygarden.repository.FruitRepository" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tag:layout>
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
                        <th scope="col">image</th>
                        <th scope="col">name</th>
                        <th scope="col">price</th>
                        <th scope="col">quantity</th>
                        <th scope="col">add to cart</th>
                    </tr>
                    </thead>
                    <tbody>


                        <%--@elvariable id="fruit" type="com.amt.mygarden.models.Fruit"--%>
                    <c:forEach items="${allFruits}" var="fruit">
                        <tr>
                            <td class="white_font"><strong>${fruit.name}</strong></td>
                            <td class="white_font">${fruit.price}</td>
                            <td>
                                <button type="button" class="col-sm-12 btn-primary" data-toggle="modal" data-target="#addCart">
                                    Add to Cart
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </jsp:body>
</tag:layout>