
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tag:layout>
    <jsp:attribute name="css">
    </jsp:attribute>
    <jsp:attribute name="bottomScrips">
    </jsp:attribute>
    <jsp:body>
        <div class="container bootdey">
            <h1>An Error occured</h1>
            <p>Message recieved : <b>${exception.message}</b></p>
            <p>URL : <b>${url}</b></p>
            <p>At :<b>${timestamp}</b></p>
            <p>Error Code: <b>${status}</b></p>
            <p>Please contact support.</p>
        </div>
    </jsp:body>
</tag:layout>