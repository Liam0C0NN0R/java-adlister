<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <h2>Your Ads</h2>
    <c:forEach var="ad" items="${userAds}">
        <div>
            <h3>${ad.title}</h3>
            <p>${ad.description}</p>

            <!-- display edit and delete buttons -->
            <form action="/ads/edit" method="GET">
                <input type="hidden" name="adId" value="${ad.id}" />
                <input type="submit" value="Edit" />
            </form>

            <form action="/ads/delete" method="post">
                <input type="hidden" name="adId" value="${ad.id}" />
                <input type="submit" value="Delete" />
            </form>
        </div>
    </c:forEach>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
