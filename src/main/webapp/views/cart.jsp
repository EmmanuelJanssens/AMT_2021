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
<%--        all custom css for this page goes here--%>
         <%--        example: --%>
         <%--        <link rel="stylesheet" href="css_file">--%>
         <%--        <style>--%>
         <%--            h1 {--%>
         <%--                color: white;--%>
         <%--            }--%>
         <%--        </style>--%>
        <style>
            .center{
                width: 150px;
                <%-- margin: 40px auto;--%>
            }

            .btn btn-round btn-danger{
                margin-top: 30px;
            }
        </style>

    </jsp:attribute>

    <jsp:attribute name="bottomScrips">
        <script>

            $('.btn-number').click(function(e){
                e.preventDefault();

                fieldName = $(this).attr('data-field');
                type      = $(this).attr('data-type');
                var input = $("input[name='"+fieldName+"']");
                var currentVal = parseInt(input.val());
                if (!isNaN(currentVal)) {
                    if(type == 'minus') {

                        if(currentVal > input.attr('min')) {
                            input.val(currentVal - 1).change();
                        }
                        if(parseInt(input.val()) == input.attr('min')) {
                            $(this).attr('disabled', true);
                        }

                    } else if(type == 'plus') {

                        if(currentVal < input.attr('max')) {
                            input.val(currentVal + 1).change();
                        }
                        if(parseInt(input.val()) == input.attr('max')) {
                            $(this).attr('disabled', true);
                        }

                    }
                } else {
                    input.val(0);
                }
            });
            $('.input-number').focusin(function(){
               $(this).data('oldValue', $(this).val());
            });
            $('.input-number').change(function() {

                minValue =  parseInt($(this).attr('min'));
                maxValue =  parseInt($(this).attr('max'));
                valueCurrent = parseInt($(this).val());

                name = $(this).attr('name');
                if(valueCurrent >= minValue) {
                    $(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
                } else {
                    alert('Sorry, the minimum value was reached');
                    $(this).val($(this).data('oldValue'));
                }
                if(valueCurrent <= maxValue) {
                    $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
                } else {
                    alert('Sorry, the maximum value was reached');
                    $(this).val($(this).data('oldValue'));
                }


            });


        </script>
    </jsp:attribute>
<jsp:body>
    <div id="cart" class="section dark_bg layout_padding ">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="heading full text_align_center">
                    <h2 class="white_font full text_align_center">Your cart</h2>
                </div>
            </div>
        </div>
        <table class="table">
            <thead>
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
                <tr>
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
                                  <button type="button" class="btn btn-default btn-number" disabled="disabled" data-type="minus" data-field="${item.fruit.name}">
                                      <!--<span class="glyphicon glyphicon-minus"></span>-->
                                      <i class="fa fa-minus"></i>
                                  </button>
                                </span>
                                <input type="text" name="${item.fruit.name}" class="form-control input-number" value="${item.quantity}" min="0" max="100">
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
                            <button class="btn btn-round btn-danger" type="submit"><i class="fa fa-shopping-cart"></i> Remove</button>
                        </p>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <p>
            <button class="btn btn-round btn-danger" type="submit"><i class="fa fa-shopping-cart"></i> Clear Cart</button>
        </p>
    </div>
 </div>

</jsp:body>
</tag:layout>