<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/stylesheet.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Only Music</title>
</head>
<body style = "background-color:FloralWhite">
<h1 style ="text-align:center;">Only Music</h1>
<!-- add navigation bar -->
<div>
<a href = "/OnlyMusic/">Home Page</a>
<a href ="registerPage">Register</a>
<a href = "loginPage">Login</a>
</div>
<!-- add welcome section -->
<section>
<p>Welcome to OnlyMusic registration page.
</p>
</section>
<!-- create spring form to collect customer details -->
<div style = "background-color:Linen">
<h2>Registration Details</h2>
<form:form action = "AddMember" modelAttribute = "customer" method= "POST">
<label>Email: </label><form:input path = "email"></form:input><br>
<label>Password: </label><form:input path = "password"></form:input><br>
<label>Address: </label><form:input path = "address"></form:input><br>
<label>Date Of Birth: </label><form:input path = "dob"></form:input><br>
<input type = "submit" value = "submit">
</form:form>
</div>

</body>
</html>