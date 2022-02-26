<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- include css styling file -->
<link rel = "stylesheet" type = "text/css" href = "/OnlyMusic/resources/css/OnlyMusic.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>OnlyMusic</title>
</head>
<!-- set background colour of the body to floral white -->
<body>
<!-- set main heading aligning it centre of the page -->
<h1 align = "center">OnlyMusic</h1>
<!-- add navigation bar -->
<div align = "center">
<a href = "/OnlyMusic/">Home Page</a>
<a href ="registerPage">Register</a>
<a href = "login">Login</a>
</div>
<!-- add welcome section -->
<section style = text-align:center>
<p>Welcome to OnlyMusic registration page.
</p>
</section>
<!-- create spring form to collect customer details -->
<div class = "regForm">
<form:form action = "AddMember" modelAttribute = "customer" method= "POST" class = "formContainer">
<h2>Registration Details</h2>
<label>Email: </label><form:input path = "email"></form:input><br>
<label>Password: </label><form:password path = "password"></form:password><br>
<label>Address: </label><form:input path = "address"></form:input><br>
<label>Date Of Birth: </label><form:input type = "date" path = "dob"></form:input><br>
<input type = "submit" value = "Register">
</form:form>
</div>

</body>
</html>