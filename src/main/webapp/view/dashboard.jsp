<%--
  Created by IntelliJ IDEA.
  User: emman
  Date: 08/11/2021
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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
                    <form action="${pageContext.request.contextPath}/demo/add" method="POST">
                        <div class="form-group">
                            <label for="fruitName">Fruit name</label>
                            <input type="text" class="form-control" id="fruitName" aria-describedby="fruitName" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="fruitAmount">Fruit amount</label>
                            <input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" placeholder="Amount">
                        </div>
                        <div class="form-group">
                            <label for="fruitDescription">Fruit Description</label>
                            <textarea type="" class="form-control" id="fruitDescription" aria-describedby="fruitDesc" placeholder="Description"></textarea>
                        </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Add</button>
                  </div>
              </div>
      </div>

  </jsp:body>
</tag:layout>