<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "/OnlyMusic/resources/css/OnlyMusic.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Only Music</title>
</head>
<body>
<h1>OnlyMusic</h1>
<!-- Add navigation bar -->
<div align = "center">
<a href = "/OnlyMusic/">Home Page</a>
<a href ="registerPage">Register</a>
<a href = "login">Login</a>
</div>
<section>
<h2>Login.
</h2>
</section>
<!-- test login credentials and return error message if incorrect -->
<c:if test="${param.error != null}">
	<i>Invalid email or password, please re-enter login details</i>
</c:if>

<!-- test user has logged out ok  -->
<c:if test="${param.logout != null}">
	<i>Logged out successfully</i>
</c:if>
<!-- create spring form to collect login details -->
<div class = "loginform">
<form:form  action = "process-login" method = "POST" class = "formContainer">
<h3>Login Details</h3>
<label for ="eamil">Email: </label><input type = "text" name = "username"/><br>
<label for = "password">Password: </label><input type = "password" name = "password"/><br>
<input type = "submit" value = "Login" class = "btn"/><br>
</form:form>
</div>

</body>
</html>