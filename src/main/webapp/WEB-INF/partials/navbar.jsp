<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <!-- User is logged in -->
                    <li><a href="/logout">Logout</a></li>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                            Menu
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li><a class="dropdown-item" href="/ads">Ad List</a></li>
                            <li><a class="dropdown-item" href="/ads/create">Create Ad</a></li>
                            <li><a class="dropdown-item" href="/ads/search">Search Ad</a></li>
                        </ul>
                    </div>

                </c:when>
                <c:otherwise>
                    <!-- User is not logged in -->
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
