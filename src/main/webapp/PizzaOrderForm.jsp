<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order Form</title>
</head>
<body>
<h1>Pizza Order Form</h1>
<form action="/pizza-order" method="post">
    <label for="crustType">Crust Type:</label>
    <select id="crustType" name="crustType">
        <option value="thin">Thin</option>
        <option value="thick">Thick</option>
    </select><br>
    <label for="sauceType">Sauce Type:</label>
    <select id="sauceType" name="sauceType">
        <option value="tomato">Tomato</option>
        <option value="bbq">BBQ</option>
    </select><br>
    <label for="size">Size:</label>
    <select id="size" name="size">
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select><br>
    <label for="toppings">Toppings:</label><br>
    <input type="checkbox" id="cheese" name="toppings" value="cheese">
    <label for="cheese">Cheese</label><br>
    <input type="checkbox" id="pepperoni" name="toppings" value="pepperoni">
    <label for="pepperoni">Pepperoni</label><br>
    <label for="address">Delivery Address:</label>
    <input type="text" id="address" name="address"><br>
    <input type="submit" value="Order">
</form>
</body>
</html>

