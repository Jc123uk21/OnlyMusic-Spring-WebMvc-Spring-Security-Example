<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<!-- include css styling file -->
<link rel = "stylesheet" type = "text/css" href = "/OnlyMusic/resources/css/stylesheet.css">
<meta  name="viewport" content="width=device-width, initial-scale=1">
<title>OnlyMusic</title>
</head>

<body style = "background-color:FloralWhite">
<h1 style ="text-align:center;">Only Music</h1>
<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>

<div>
<sec:authorize access = 'hasAnyAuthority("customer", "admin")'>
<a href ="userHome">User Home</a>
</sec:authorize>
<a href = "/OnlyMusic/">Home Page</a>
</div>
<form:form action = "logout" method = "POST" align = "right">
<input type = "submit" value = "logout"/>
</form:form>
<i style = color:red>Access denied, you do not have authority to access the resource you are requesting </i>
</body>
</html>