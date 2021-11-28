<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tag:layout>
    <jsp:body>

        <div class="row-fluid top30 pagetitle">
            <div class="container">
                <div class="row">
                    <div class="col-md-12"><h1>Fruits</h1></div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="list-group">
                        <a href="${pageContext.request.contextPath}/fruits" class="list-group-item list-group-item-action">All</a>
                        <c:forEach items="${categories}" var="category">
                            <a href="${pageContext.request.contextPath}/categories/${category.name}/fruits" class="list-group-item list-group-item-action">${category.name}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-9">
                    <c:if test="${empty(allFruits)}">
                        No Fruits found for this category
                    </c:if>
                    <c:forEach items="${allFruits}" var="fruit">
                        <a href="/fruits/${fruit.name}" class="row">
                            <div class="col-sm-4">
                                <c:choose>
                                    <c:when  test="${fruit.price <= 0}">
                                        <img src = "${pageContext.request.contextPath}/images/comming-soon.png" alt="" style="position:absolute; top:0; left:0">
                                    </c:when>
                                    <c:when  test="${fruit.quantity <= 0}">
                                        <img src = "${pageContext.request.contextPath}/images/unavailable.png" alt="" style="position:absolute; top:0; left:0">
                                    </c:when>
                                </c:choose>
                                <img src="${pageContext.request.contextPath}/download?filename=${fruit.image}" class="img-responsive" alt="">
                            </div>
                            <div class="col-sm-8">
                                <h3 class="title">${fruit.name}</h3>
                                <div>${fruit.description}</div>
                                <p class="text-muted">${fruit.price} CHF</p>
                            </div>
                            <div class="col-sm-8">
                                <c:if  test="${fruit.quantity > 0 && fruit.price > 0}">
                                    <form:form action="${pageContext.request.contextPath}/fruits/${fruit.name}/add-to-cart"
                                               method="POST"
                                               modelAttribute="fruit"
                                               id="addToCartForm"
                                    >
                                        <button type="submit" class="btn btn-round btn-danger"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                                    </form:form>
<%--                                <a href="${pageContext.request.contextPath }/fruits/${fruit.name}/add/1" class="button"><i class="fa fa-shopping-cart"></i> Add to Cart</a>--%>
                                </c:if>
                            </div>
                        </a>
                        <hr/>
                    </c:forEach>
                </div>
            </div>
        </div>
    </jsp:body>
</tag:layout>