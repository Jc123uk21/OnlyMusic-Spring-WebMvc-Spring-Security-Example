<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="/stylesheet.css"%></style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Only Music</title>
</head>
<body style = "background-color:FloralWhite">
<h1 style ="text-align:center;">Only Music</h1>
<!-- Add navigation bar -->
<div>
<a href = "/OnlyMusic/">Home Page</a>
<a href ="registerPage">Register</a>
<a href = "loginPage">Login</a>
</div>
<section>
<p>Welcome to OnlyMusic login page.
</p>
</section>
<!-- create spring form to collect login details -->
<h2>Login Details</h2>
<div style = "background-color:Linen">
<form:form modelAttribute = "customer">
<label>Email: </label><form:input path = "email"></form:input><br>
<label>Password: </label><form:input path = "password"></form:input><br>
<input type = "submit" value = "login"/>
</form:form>
</div>
</body>
</html>