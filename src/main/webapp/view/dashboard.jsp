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

      <h1>Dashboard</h1>

  </jsp:body>
</tag:layout>