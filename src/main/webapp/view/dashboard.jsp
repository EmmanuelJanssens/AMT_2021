<%--
  Created by IntelliJ IDEA.
  User: emman
  Date: 08/11/2021
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
      <script>
          $(document).ready(function() {
            $('select').niceSelect();
    });
      </script>
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

      <div class="container row">
          <div class = "col-sm-6">
                  <button type="button" class="col-sm-12 btn-primary" data-toggle="modal" data-target="#addfruit">
                      Add Fruit
                  </button>
                  <button type="button" class="col-sm-12 btn-primary">Delete Fruit</button>
          </div>
      </div>

      <div class="modal fade" id="addfruit" tabindex="-1" role="dialog" aria-labelledby="addfruit" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
              <div class="modal-content">
                  <div class="modal-header">
                      <h5 class="modal-title" id="addFruitTitle">Add a fruit</h5>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                      </button>
                  </div>
                  <div class="modal-body">
                    <%--@elvariable id="fruit" type="com.amt.mygarden.models.Fruit"--%>
                    <form:form action="${pageContext.request.contextPath}/fruits/add" method="POST" modelAttribute="fruit">
                        <!--TODO change to file-->
                        <div class="form-group">
                            <form:label for="fruitName" path="image">Fruit name</form:label>
                            <form:input type="text" class="form-control" id="fruitImage" aria-describedby="fruitImage" placeholder="Image" path="image"/>
                        </div>
                        <div class="form-group">
                            <form:label for="fruitName" path="name">Fruit name</form:label>
                            <form:input type="text" class="form-control" id="fruitName" aria-describedby="fruitName" placeholder="Name" path="name" required=""/>
                        </div>
                        <div class="form-group">
                            <form:label for="fruitPrice" path="price">Fruit price</form:label>
                            <form:input type="text" class="form-control" id="fruitPrice" aria-describedby="fruitPrice" placeholder="Price" path="price" required=""/>
                        </div>
                        <div class="form-group">
                            <form:label for="fruitAmount" path="quantity">Fruit amount</form:label>
                            <form:input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" placeholder="quantity" path="quantity" required=""/>
                        </div>
                        <div class="form-group">
                            <form:label for="fruitCategories" path="categories">Fruit category</form:label>
                            <form:select
                                    path="categories"
                                    class="form-control"
                                    id="fruitCategories"
                                    items="${allFruitCategories}"
                                    multiple="true"
                                    aria-label="multiple select"
                            />

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                    </form:form>
                  </div>

              </div>
      </div>

  </jsp:body>
</tag:layout>