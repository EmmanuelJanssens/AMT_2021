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

          const url = "${pageContext.request.contextPath}/fruits/description/"

          function changeContent() {
              $('#addFruitFormWrapper').load('${pageContext.request.contextPath}/addFruitModal',function (){
                  $('#addfruit').modal('show');
              });
          }
          function closeDialog(){
              $('#addfruit').remove();
              $('div').remove(".modal-backdrop");
          }

          function checkDescriptionValidity(url,description)
          {
              $.get(url+description,function(data){
                  console.log(data)
                  if(data===true)
                  {
                      $("#exists").text("Already exists")
                      $("#exists").addClass('alert alert-dark')
                      return false
                  }
                  else
                  {
                      $("#exists").removeClass('alert alert-dark')
                      $("#exists").text("")
                      return true;
                  }
              });

              return false
          }
          <%--@elvariable id="fruitObj" type="com.amt.mygarden.models.Fruit"--%>
          function addFruit(url){
                const description = $("#fruitDescription").val()
              if(!checkDescriptionValidity(url,description))
                  return false;
              $.get(url+description,function(data){
                  {
                      if($("#addFruitForm").isValid())
                      {
                          $("#addFruitForm").submit()
                      }
                  }
              })
          }

          $("#addFruitForm").submit(function(e){
              return false
          });

      </script>
    </jsp:attribute>
  <jsp:body>


      <div id="addFruitFormWrapper">

      </div>

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
                          <button type="button" class="col-sm-12 btn-primary" data-toggle="modal" data-target="#addfruit" onclick="changeContent()">
                              Add Fruit
                          </button>
                      </th>
                  </tr>
                  <tr>
                      <th scope="col">image</th>
                      <th scope="col">name</th>
                      <th scope="col">price</th>
                      <th scope="col">quantity</th>
                      <th scope="col">description</th>
                      <th scope="col">delete</th>
                  </tr>
                  </thead>
                  <tbody>


                      <%--@elvariable id="fruit" type="com.amt.mygarden.models.Fruit"--%>
                  <c:forEach var="fruit" items="${allFruits}">
                      <tr>
                          <td><img
                                  style="display: block"
                                  src="${pageContext.request.contextPath}/download?filename=${fruit.name}${fruit.image}" alt="image"
                                  width="10%"
                                  height="10%"
                          /> </td>
                          <td class="white_font"><strong>${fruit.name}</strong></td>
                          <td class="white_font">${fruit.price}</td>
                          <td class="white_font">${fruit.quantity}</td>
                          <td class="white_font">${fruit.description}</td>
                          <td>
                              <span aria-hidden="true" >&times;</span>
                          </td>

                      </tr>
                  </c:forEach>

                  </tbody>
              </table>
          </div>

      </div>



  </jsp:body>
</tag:layout>