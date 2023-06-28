<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Your head section and other imports -->
</head>
<body>
<!-- Your navbar or other common components -->

<div class="container">
    <h1>Welcome to the Adlister!</h1>

    <!-- Iterate through the ads and generate links to individual ad pages -->
    <c:forEach var="ad" items="${ads}">
        <a href="/ads/show?id=${ad.id}">${ad.title}</a><br>
        <!-- Display other ad information as needed -->
    </c:forEach>
</div>

<!-- Your scripts and other imports -->
</body>
</html>
