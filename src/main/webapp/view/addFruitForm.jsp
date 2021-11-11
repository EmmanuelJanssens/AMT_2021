<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: emman
  Date: 11/11/2021
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form:form action="${pageContext.request.contextPath}/demo/add" method="POST">
          <div class="form-group">
            <form:label for="fruitName" path="image">Fruit name</form:label>
            <!--TODO change to file-->
            <form:input type="text" class="form-control" id="fruitName" aria-describedby="fruitName" placeholder="Name" path="image"/>
          </div>
          <div class="form-group">
            <form:label for="fruitName" path="name">Fruit name</form:label>
            <form:input type="text" class="form-control" id="fruitName" aria-describedby="fruitName" placeholder="Name" path="name"/>
          </div>
          <div class="form-group">
            <form:label for="fruitPrice" path="price">Fruit price</form:label>
            <form:input type="text" class="form-control" id="fruitPrice" aria-describedby="fruitName" placeholder="Name" path="price"/>
          </div>
          <div class="form-group">
            <form:label for="fruitAmount" path="quantity">Fruit amount</form:label>
            <form:input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" placeholder="quantity" path="quantity"/>
          </div>
          <div class="form-group">
            <form:label for="fruitAmount" path="categories">Fruit amount</form:label>
            <form:input type="text" class="form-control" id="fruitAmount" aria-describedby="fruitAmount" placeholder="quantity" path="amount"/>
            <form:select name="categories" id="categories" path="categories">
              <form:option value="Exotic">Volvo</form:option>
              <form:option value="Citrus">Saab</form:option>
              <form:option value="Berry">Opel</form:option>
            </form:select>
          </div>
          <div class="form-group">
            <form:label for="fruitDescription" path="">Fruit Description</form:label>
            <form:textarea type="" class="form-control" id="fruitDescription" aria-describedby="fruitDesc" placeholder="Description" path=""></form:textarea>
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" >Add</input>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>