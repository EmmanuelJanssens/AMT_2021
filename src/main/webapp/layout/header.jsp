<!-- header -->
<header id="home">
    <!-- header inner -->
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                    <div class="full">
                        <div class="center-desk">
                            <div class="logo"> <a href="index.jsp"><img src="images/logo.png" alt="#"></a> </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                    <div class="menu-area">
                        <div class="limit-box">
                            <nav class="main-menu">
                                <ul class="menu-area-main">
                                    <li class="active"><a href="#home">Home</a></li>
                                    <li><a href="#about">About Us</a></li>
                                    <li><a href="${pageContext.request.contextPath}/fruits">fruits ${pageContext.request.contextPath}</a></li>
                                    <li><a href="#blog">Blog</a></li>
                                    <li><a href="${pageContext.request.contextPath}/carts/my-cart">cart ${pageContext.request.contextPath}</a></li>
                                    <li><a href="#contact">Contact Us</a></li>
                                    <!--TODO display only if logged in a s admin-->
                                    <li><a href="${pageContext.request.contextPath}/dashboard">dashboard ${pageContext.request.contextPath} </a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end header inner -->
</header>
<!-- end header -->