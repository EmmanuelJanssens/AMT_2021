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

            <%-- Quantity buttons group --%>
            $('.btn-number').click(function(e){
                e.preventDefault();

                fieldName = $(this).attr('data-field');
                type      = $(this).attr('data-type');
                idItem   = $(this).attr('data-itemId');

                var input = $("input[name='"+fieldName+"']");
                var currentVal = parseInt(input.val());
                if (!isNaN(currentVal)) {
                    if(type === 'minus') {
                        if(currentVal > input.attr('min')) {
                            $.post("${pageContext.request.contextPath}/fruits/"+fieldName+"/remove-from-cart", {_method: "delete"})
                                .done(() => {
                                    input.val(currentVal - 1).change();
                                    if (currentVal <= 1) {
                                        window.location.reload()
                                    }
                                })
                        }
                    } else if(type === 'plus') {
                        if(currentVal < input.attr('max')) {
                            $.post("${pageContext.request.contextPath}/fruits/"+fieldName+"/add-to-cart")
                                .done(() => {
                                    input.val(currentVal + 1).change();
                                    if((currentVal + 1) === input.attr('max')) {
                                        $(this).attr('disabled', true);
                                    }
                                })
                        }
                    }
                } else {
                    input.val(0);
                }
            });

            <%-- Empty cart view --%>
            window.onload = function checkCart(){
                var items = $('.cartContent');

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
                                      <button type="button" class="btn btn-default btn-number" data-itemId="${item.id}" data-type="minus" data-field="${item.fruit.name}">
                                          <!--<span class="glyphicon glyphicon-minus"></span>-->
                                          <i class="fa fa-minus"></i>
                                      </button>
                                    </span>
                                    <input id="inputQuantity" type="text" name="${item.fruit.name}" class="form-control input-number" value="${item.quantity}" min="0" max="100" readonly>
                                    <span class="input-group-btn">
                                      <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="${item.fruit.name}">
                                          <!--<span class="glyphicon glyphicon-plus"></span>-->
                                          <i class="fa fa-plus"></i>
                                      </button>
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