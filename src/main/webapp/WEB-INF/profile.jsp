<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    window.onload = function() {
        var today = new Date();
        var hour = today.getHours();
        var greeting;

        if (hour < 12) {
            greeting = "Good morning";
        } else if (hour < 18) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        document.getElementById('greeting').innerText = greeting + ", ${username}!";
    }
</script>

<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1 id="greeting"></h1>
        <h3>Viewing your profile.</h3>
    </div>

</body>
</html>
