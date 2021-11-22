<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:layout>
    <jsp:attribute name="css">
        <style>
            /*panel*/
            .panel {
                margin-top: 20px;
                border: none;
                box-shadow: none;
            }

            /*product list*/
            .prod-cat li a{
                border-bottom: 1px dashed #d9d9d9;
            }

            .prod-cat li a {
                color: #3b3b3b;
            }

            .prod-cat li ul {
                margin-left: 30px;
            }

            .prod-cat li ul li a{
                border-bottom:none;
            }
            .prod-cat li ul li a:hover,.prod-cat li ul li a:focus, .prod-cat li ul li.active a , .prod-cat li a:hover,.prod-cat li a:focus, .prod-cat li a.active{
                background: none;
                color: #ff7261;
            }

            .product-list img{
                width: 100%;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
            }

            .adtocart i{
                color: #fff;
                font-size: 25px;
                line-height: 42px;
            }

            .pro-img-details {
                margin-left: -15px;
            }

            .pro-img-details img {
                width: 100%;
            }

            .pro-d-title {
                font-size: 16px;
                margin-top: 0;
            }

            .product_meta {
                border-top: 1px solid #eee;
                border-bottom: 1px solid #eee;
                padding: 10px 0;
                margin: 15px 0;
            }

            .product_meta span {
                display: block;
                margin-bottom: 10px;
            }
            .product_meta a, .pro-price{
                color:#fc5959 ;
            }

            .quantity {
                width: 120px;
            }

            .pro-img-list a {
                float: left;
                margin-right: 10px;
                margin-bottom: 10px;
            }

        </style>
    </jsp:attribute>
    <jsp:body>
    <div class="container bootdey">
        <div class="col-md-12">
            <section class="panel">
                <div class="panel-body row">
                    <div class="col-md-6">
                        <div class="pro-img-details">
                            <img src="${pageContext.request.contextPath}/download?filename=${fruit.image}" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h4 class="pro-d-title">
                            <a href="#" class="">
                                ${fruit.name}
                            </a>
                        </h4>
                        <p>
                            ${fruit.description}
                        </p>
                        <div class="product_meta">
                            <span class="posted_in">
                                <strong>Categories:</strong>
                                <c:forEach items="${fruit.categories}" var="category">
                                    <a rel="tag" href="#">${category.name}</a>
                                </c:forEach>
                            </span>
                        </div>
                        <div class="m-bot15"> <strong>Price : </strong> <span class="pro-price">${fruit.price} CHF</span></div>
                        <div class="form-group">
                            <label>Quantity</label>
                            <input type="quantiy" placeholder="1" class="form-control quantity">
                        </div>
                        <p>
                            <button class="btn btn-round btn-danger" type="button"><i class="fa fa-shopping-cart"></i> Add to Cart</button>
                        </p>
                    </div>
                </div>
            </section>
        </div>
    </div>
    </jsp:body>
</tag:layout>
