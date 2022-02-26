<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/stylesheet.css"%></style>
<meta charset="ISO-8859-1">
<title>OnlyMusic</title>
</head>
<!-- set background colour of the body to floral white -->
<body style = "background-color:FloralWhite">
<!-- set main heading aligning it centre of the page -->
<h1 align = "center">OnlyMusic Admin's Login</h1>
<!-- add navigation bar -->
<div align = "center">
<a href = "/OnlyMusic/">Home Page</a>
<a href ="registerPage">Register</a>
<a href = "loginPage">Login</a>
<a href = "adminLogin">Admin's Login</a>
</div>
<section>
<!-- create spring form to collect login details -->
<h2 align = "center">Login</h2>
<div style = "background-color:Linen" align = "center">
<h3>Please enter login credentials</h3>
<form:form  method = "POST">
<label>Email: </label><input type = "text" name = "username"/><br>
<label>Password: </label><input type = "password" name = "password"/><br>
<input type = "submit" value = "login"/>
</form:form>
</div>
</section>
</body>
</html>