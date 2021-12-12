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

     <jsp:attribute name="css">
        <style>
            .center{
                width: 150px;
            }

            .btn btn-round btn-danger{
                margin-top: 30px;
            }

            .removeBtnLink{
                color: white;
            }

            #inputQuantity{
                background-color: white;
            }

        </style>

    </jsp:attribute>

    <jsp:attribute name="bottomScrips">
        <script>
            <%-- Empty cart view --%>
            window.onload = function checkCart(){
                if($("#oneItem").length === 0){
                    $('#cartTitle').text("Oh no! Your cart is empty :(")
                    $('#idThead').hide();
                    $('#removeBtn').hide();
                } else {
                    $('#cartTitle').text("Your cart")
                }
            }
        </script>
    </jsp:attribute>

    <jsp:body>
    <div id="cart" class="section dark_bg layout_padding ">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="heading full text_align_center">
                        <h2 id="cartTitle" class="white_font full text_align_center">Your cart</h2>
                    </div>
                </div>
            </div>
            <table class="table">
                <thead id="idThead">
                <tr>
                    <th scope="col">image</th>
                    <th scope="col">name</th>
                    <th scope="col">quantity</th>
                    <th scope="col">price</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="item" type="com.amt.mygarden.models.Item"--%>
                <c:forEach  items="${allItems}" var="item">
                    <tr id="oneItem">
                        <td><img
                                style="display: block"
                                src="${pageContext.request.contextPath}/download?filename=${item.fruit.image}" alt="image"
                                width="10%"
                                height="10%"
                        /> </td>
                        <td class="white_font"><strong>${item.fruit.name}</strong></td>
                        <td>
                            <div class="center">
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <form:form method="delete" action="/fruits/${item.fruit.name}/remove-from-cart">
                                            <button type="submit" class="btn btn-default">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </form:form>
                                    </span>
                                    <input id="inputQuantity" type="text" name="${item.fruit.name}" class="form-control input-number" value="${item.quantity}" readonly>
                                    <span class="input-group-btn">
                                        <form:form method="post" action="/fruits/${item.fruit.name}/add-to-cart">
                                            <button type="submit" class="btn btn-default">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </form:form>
                                    </span>
                                </div>
                            </div>
                        </td>
                        <td class="white_font">${item.fruit.price}</td>
                        <td>
                            <p>
                                <button class="btn btn-round btn-danger" type="submit"><i class="fa fa-shopping-cart"></i>
                                    <a class="removeBtnLink" href="${pageContext.request.contextPath }/cart/delete/${item.id}">
                                        Remove
                                    </a>
                                </button>
                            </p>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <p>
            <button id="removeBtn" class="btn btn-round btn-danger" type="submit"><i class="fa fa-shopping-cart"></i>
                    <a class="removeBtnLink" href="${pageContext.request.contextPath }/cart/delete/all">
                    Clear Cart
                    </a>
                </button>
            </p>
        </div>
    </div>

    </jsp:body>
</tag:layout>