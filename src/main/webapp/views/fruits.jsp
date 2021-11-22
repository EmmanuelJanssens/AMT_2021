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
                <div class="col-md-9">
                    <c:forEach items="${allFruits}" var="fruit">
                        <a href="/fruits/${fruit.name}" class="row">
                            <div class="col-sm-4">
                                <img src="${pageContext.request.contextPath}/download?filename=${fruit.image}" class="img-responsive" alt="">
                            </div>
                            <div class="col-sm-8">
                                <h3 class="title">${fruit.name}</h3>
                                <div>${fruit.description}</div>
                                <p class="text-muted">${fruit.price} CHF</p>
                                <p>
                                    <button class="btn btn-round btn-danger" type="submit"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                                </p>
                            </div>
                        </a>
                        <hr/>
                    </c:forEach>
                </div>
            </div>
        </div>
    </jsp:body>
</tag:layout>