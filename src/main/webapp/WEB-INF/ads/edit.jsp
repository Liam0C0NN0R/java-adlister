<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit Ad</title>
</head>
<body>
<h1>Edit Ad</h1>
<form action="/ads/edit" method="post">
  <input type="hidden" name="adId" value="${ad.id}">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" id="title" name="title" value="${ad.title}" required>
  </div>
  <div class="form-group">
    <label for="description">Description</label>
    <textarea class="form-control" id="description" name="description" rows="3" required>${ad.description}</textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
