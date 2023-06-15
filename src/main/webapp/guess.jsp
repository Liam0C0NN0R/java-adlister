<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/partials/head.jsp" %>
<%@ include file="/partials/navbar.jsp" %>

<html>
<head>
  <title>Guessing Game</title>
</head>
<body>
<form action="/guess" method="post">
    <label for="difficulty">Select difficulty:</label>
    <select id="difficulty" name="difficulty">
      <option value="easy">Easy (1-2)</option>
      <option value="normal">Normal (1-3)</option>
      <option value="hard">Hard (1-10)</option>
      <option value="impossible">Impossible (1-100)</option>
    </select>
    <input type="submit" value="Start Game">
  </form>


  <!-- jQuery, Popper.js, and Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>

