<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/partials/head.jsp" %>

<html>
<head>
  <title>Game Outcome</title>
  <script src="Static/confetti.js"></script>
  <link rel="stylesheet" type="text/css" href="Static/Guesser.css">
</head>
<body>
<h1><%= session.getAttribute("message") %></h1>
<!-- jQuery, Popper.js, and Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>

<script>
  // Get the message from the session
  var message = '<%= session.getAttribute("message") %>';

  // Check if the message is "You Won!"
  if (message === "You Won!") {

    const start = () => {
      setTimeout(function() {
        confetti.start()
      }, 50);
    };
    const stop = () => {
      setTimeout(function() {
        confetti.stop()
      }, 5000);
    };

    start();
    // If the message is "You Lost!"
  } else if (message === "You Lost!") {
    // Create a new image element
    var img = document.createElement("img");
    img.src = "./Static/51F6LDLBsPL._AC_UF1000,1000_QL80_.jpg";
    document.body.appendChild(img);

    // Create a new audio element
    var audio = document.createElement("audio");
    audio.src = "./Static/Official Rickroll Download (Pls don't give me copyright strike).mp3";
    audio.autoplay = true;
    audio.loop = true;
    document.body.appendChild(audio);
  }
</script>

</body>
</html>

