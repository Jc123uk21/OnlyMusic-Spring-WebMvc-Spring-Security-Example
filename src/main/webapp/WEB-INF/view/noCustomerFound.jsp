<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<body>
<h1>Only Music</h1>
<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>
<div>
<sec:authorize access = 'hasAnyAuthority("customer", "admin")'>
<a href ="userHome">User Home</a>
</sec:authorize>
<sec:authorize access = 'hasAnyAuthority("customer", "admin")'>
<a href = "getTrackList">Track List</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href = "customerList">Customers List</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href ="adminRegisterPage">Register New Admin User</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href = "deleteAdminUser">Delete Admin User</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href = "findCustomer">Find Customer</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href = "DeleteCustomer">Delete Customer</a>
</sec:authorize>
<sec:authorize access ='hasAuthority("admin")'>
<a href = "AddTrack">Add New Track</a>
</sec:authorize>
<sec:authorize access = 'hasAuthority("admin")'>
<a href = "deleteTrack">Delete track</a>
</sec:authorize>
</div>
<form:form action = "logout" method = "POST" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>

<div>
<h2>No Customer Found! </h2>
<p>No customer found with the inputed Username!</p>
</div>
<div class ="userHomePageImage">
</div>
</body>
</html>