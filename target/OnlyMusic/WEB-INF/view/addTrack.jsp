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

<meta  name="viewport" content="width=device-width, initial-scale=1">
<title>OnlyMusic</title>
</head>
<body>
<!-- Add main heading -->
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
<a href ="AdminRegisterPage">Register New Admin User</a>
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
<!-- Add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
<!-- Add page heading -->
<div>
<h2>Add New Track </h2>
</div>
<!-- Add form to collect track details -->
<div class = "addTrackForm">
<form:form action = "addTrack" modelAttribute = "track" method= "POST" class = "formContainer">
<h3>Track Details</h3>
<label>Track Name</label><form:input path = "trackName"></form:input><br>
<label>Artist</label><form:input path = "artist"></form:input><br>
<label>Release Date</label><form:input type = "date" path = "releaseDate"></form:input><br>
<label>Track Price</label><form:input path = "trackPrice"></form:input><br>
<label>File Path</label><form:input path = "audioFilePath"></form:input><br>
<label>Duration</label><form:input path = "duration"></form:input><br>
<input type = "submit" value = "add Track"/>
</form:form>
</div>
</body>
</html>