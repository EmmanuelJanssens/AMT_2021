<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- header -->
<header class="full_bg">
    <!-- header inner -->
    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                    <div class="full">
                        <div class="center-desk">
                            <div class="logo">
                                <a href="<c:url value='/' />"><img src="<c:url value='/images/logo_mg.png' />" alt="#"></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                    <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="<c:url value='/' />">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value='/fruits' />">Fruits</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value='/cart' />">Cart</a>
                                </li>
                                <sec:authorize access="isAuthenticated()">
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/admin/dashboard' />">Dashboard</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/admin/categoryDashboard' />">Category Dashboard</a>
                                        </li>
                                    </sec:authorize>
                                    <li class="nav-item">
                                        <form:form action="/logout"
                                                   method="POST"
                                        >
                                            <button type="submit" class="btn btn-light"><sec:authentication property="principal" /> </button>
                                        </form:form>
                                    </li>
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/login" />">Login</a>
                                    </li>
                                </sec:authorize>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- end header inner -->
    <!-- end header -->
</header>
<!-- end banner -->