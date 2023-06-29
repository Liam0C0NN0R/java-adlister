<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<div class="container">
    <h1>Welcome to the Adlister!</h1>

    <c:forEach var="ad" items="${ads}">
        <a href="/ads/show?id=${ad.id}">${ad.title}</a><br>
        <p>${fn:substring(ad.description, 0, 300)}${ad.description.length() > 300 ? '...' : ''}</p>
    </c:forEach>
</div>
</body>
</html>
