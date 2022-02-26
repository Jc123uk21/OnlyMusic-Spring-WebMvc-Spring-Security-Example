<%@ page isELIgnored="false" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<!-- include css style sheet -->
<link rel = "stylesheet" type = "text/css" href = "/OnlyMusic/resources/css/OnlyMusic.css">
<meta  name="viewport" content="width=device-width, initial-scale=1">
<style>
</style>
<title>OnlyMusic</title>
</head>

<!-- style the body -->
<body>

<!-- set main heading aligning it centre of the page -->
<h1>Only Music</h1>

<!-- show logged in username -->
<h4 style = "text-align:right;">logged in as : ${username}</h4>

<!-- add navigation bar with spring security authorisation-->
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
<!-- add logout button -->
<form:form action = "logout" method = "POST" align = "right" class = "logoutBtn">
<input type = "submit" value = "logout"/>
</form:form>
</div>
<div>
<h2>Track List</h2>
</div>

<!-- create table to capture customer data -->
<div align = "center">
<h2>Available Tracks</h2>
<table>
	<thead>
	<tr>
		<td>Track ID</td>
		<td>Track Name</td>
		<td>Artist</td>
		<td>Release Date</td>
		<td>Duration(mins)</td>
		<td>Track Price</td>
		<td>Download Link</td>
	</tr>
	</thead>

	<c:forEach var ="track" items ="${tracks}">
	 	<tr>
	 	<td><c:out value = "${track.trackId}"/></td>
		<td><c:out value = "${track.trackName}"/></td>
		<td><c:out value = "${track.artist}"/></td>
		<td><c:out value = "${track.releaseDate}"/></td>
		<td><c:out value = "${track.duration}"/></td>
		<td><c:out value = "${track.trackPrice}"/></td>
		<td><c:out value = "${track.audioFilePath}"/></td>
	 </tr>	
	 </c:forEach>	
</table>
</div>
<div class = "tracklistImage">

</div>

</body>
</html>