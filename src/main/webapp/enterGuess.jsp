<%@ page session="true" %>
<h1>Guess a number between 1 and <%= session.getAttribute("maxNumber") %></h1>
<form action="/checkGuess" method="post">
  <input type="number" name="guess" min="1" max="<%= session.getAttribute("maxNumber") %>">
  <input type="submit" value="Submit Guess">
</form>

