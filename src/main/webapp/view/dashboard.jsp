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

      <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.5.2/bootbox.min.js"/>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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
                                      <li class="active"><a href="#" onclick="openDialog()">Add a fruit</a></li>
                                  </ul>
                              </nav>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </jsp:body>
</tag:layout>