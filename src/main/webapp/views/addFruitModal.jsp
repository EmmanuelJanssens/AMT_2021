<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: emman
  Date: 13/11/2021
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>

<div class="modal fade" id="addfruit" tabindex="1" role="dialog" aria-labelledby="addfruit" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addFruitTitle">Add a fruit</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" onclick="closeDialog()" >&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form action="${pageContext.request.contextPath}/fruits/" method="POST" modelAttribute="fruit" enctype="multipart/form-data">
        <!--TODO change to file-->
        <div class="form-group">
          <form:label for="fruitName" path="image">Fruit name</form:label>
          <form:input type="file" class="form-control" id="fruitImage" aria-describedby="fruitImage" placeholder="Image" path="imageFile"/>
        </div>
        <div class="form-group">
          <form:label for="fruitName" path="name">Fruit name</form:label>
          <form:input type="text" class="form-control" id="fruitName" aria-describedby="fruitName" placeholder="Name" path="name" required="true"/>
        </div>
        <div class="form-group">
          <form:label for="fruitPrice" path="price">Fruit price</form:label>
          <form:input type="text" class="form-control" id="fruitPrice" aria-describedby="fruitPrice" placeholder="Price" path="price" required="true"/>
        </div>
        <div class="form-group">
          <form:label for="fruitAmount" path="quantity">Fruit amount</form:label>
          <form:input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" placeholder="quantity" path="quantity" required="true"/>
        </div>
        <div class="form-group">
          <form:label for="fruitDescription" path="description">Fruit amount</form:label>
          <form:textarea type="text" class="form-control" id="fruitDescription" aria-describedby="fruitDescription" placeholder="description" path="description" required="true"/>
        </div>
        <div class="form-group">
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
            <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeDialog()">Close</button>
            <button type="submit" class="btn btn-primary">Add</button>
          </div>
          </form:form>
        </div>

      </div>
    </div>
  </div>
</div>