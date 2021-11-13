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
        <section class="slider_section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="full">
                            <h1><strong class="cur">Best</strong><br>Fresh Red Apple</h1>
                            <a href="${pageContext.request.contextPath}/helloServlet">Hello Servlet</a>
                            <a href="${pageContext.request.contextPath}/fruits">Get all fruits</a>
                            <a href="${pageContext.request.contextPath}/fruits/Banana">Get a specific fruit</a>
                            <a href="${pageContext.request.contextPath}/fruits/category/Exotic">Get all fruits from a specific category</a>
                            <p>The bestest apple in amt</p>
                            <div class="button_section"><a class="main_bt" href="#">Buy Now</a></div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="full text_align_center">
                            <img class="slide_img" src="images/slider_img.png" alt="#" />
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- about -->
        <div id="about" class="about layout_padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img class="img-responsive" src="images/about_img.png" alt="#" />
                    </div>
                    <div class="col-md-6">
                        <div class="heading margin_top_30">
                            <h2>About our shop</h2>
                        </div>
                        <div class="full margin_top_20">
                            <p>We are an online shop that sells fruits and vegetables. Our produts are of the best quality you can find. Most of our products are BIO and come from fair working conditions </p>
                        </div>
                        <div class="full margin_top_30">
                            <a class="main_bt" href="#">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end about -->
        <!-- section -->
        <div id="fruits" class="section dark_bg layout_padding left_white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading full text_align_center">
                            <h2 class="white_font full text_align_center">Our Fruits</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 margin_top_30">
                        <div class="full fr">
                            <img class="img-responsive" src="images/f1.png" alt="#" />
                        </div>
                        <div class="full text_align_center">
                            <h3 class="white_font">Black Grapes<br><strong class="theme_blue">Fresh Fruit</strong></h3>
                        </div>
                    </div>
                    <div class="col-md-4 margin_top_30">
                        <div class="full fr">
                            <img class="img-responsive" src="images/f2.png" alt="#" />
                        </div>
                        <div class="full text_align_center">
                            <h3 class="white_font">Pineapple<br><strong class="theme_blue">Fresh Fruit</strong></h3>
                        </div>
                    </div>
                    <div class="col-md-4 margin_top_30">
                        <div class="full fr">
                            <img class="img-responsive" src="images/f3.png" alt="#" />
                        </div>
                        <div class="full text_align_center">
                            <h3 class="white_font">Bananas<br><strong class="theme_blue">Fresh Fruit</strong></h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end section -->
        <!-- section -->
        <div class="section layout_padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="full main_heading_1">
                            <h2>Fresh Lemon</h2>
                            <p>This lemon is as cold as your ex-girlfriend's heart </p>
                        </div>
                        <div class="full margin_top_30">
                            <a class="main_bt" href="#">Read More</a>
                        </div>
                    </div>
                    <div class="col-md-6 margin_top_30 padding_right_0">
                        <div class="full">
                            <img src="images/green_fr.png" alt="#" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end section -->
        <!-- section -->
        <div id="blog" class="section dark_bg layout_padding right_white">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heading full text_align_center">
                            <h2 class="white_font full text_align_center">Our Blog</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 margin_top_30">
                        <div class="full" style="overflow: hidden;">
                            <div class="full bl">
                                <img class="img-responsive" src="images/blog1.png" alt="#" />
                            </div>
                            <div class="full blog_blue text_align_center">
                                <h3 class="white_font">Post by Teo Ferrari 27/07/2019</h3>
                                <p>Incredible product !!</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 margin_top_30">
                        <div class="full" style="overflow: hidden;">
                            <div class="full bl">
                                <img class="img-responsive" src="images/blog2.png" alt="#" />
                            </div>
                            <div class="full blog_blue text_align_center">
                                <h3 class="white_font">Post by Emmanuel Janssens 27/07/2019</h3>
                                <p>Very peachy</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 margin_top_30">
                        <div class="full" style="overflow: hidden;">
                            <div class="full bl">
                                <img class="img-responsive" src="images/blog3.png" alt="#" />
                            </div>
                            <div class="full blog_blue text_align_center">
                                <h3 class="white_font">Post by David Mark 27/07/2019</h3>
                                <p>Apple time !</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end section -->
        <!-- section -->
        <div id="contact" class="section layout_padding">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-6 padding_left_0">
                        <div class="full">
                            <img class="float-left" src="images/fruit_img.png" alt="#" />
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="heading">
                            <h2>Request a <strong class="theme_blue">Call Back</strong></h2>
                        </div>
                        <div class="full margin_top_20">
                            <form>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <input class="form-control" placeholder="Your Name" type="text" required="">
                                    </div>
                                    <div class="col-sm-12">
                                        <input class="form-control" placeholder="Email" type="Email" required="">
                                    </div>
                                    <div class="col-sm-12">
                                        <input class="form-control" placeholder="Phone" type="text" required="">
                                    </div>
                                    <div class="col-sm-12">
                                        <textarea class="form-control textarea" placeholder="Message"></textarea>
                                    </div>
                                </div>
                                <button class="main_bt">Send</button>
                            </form>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <!-- end section -->
    </jsp:body>
</tag:layout>
