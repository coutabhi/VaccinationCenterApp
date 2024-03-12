<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AfterLoginPage</title>
</head>
<body>
	<h1 style="text-align: center; width: 100%">View All Vaccination Centers</h1>
	<table width="100%" border="1">
		<tr>
			<th>Center ID</th>
			<th>Center Name</th>
			<th>Center City</th>
		</tr>

		<c:forEach var="center" items="${centerList}">
			<c:url var="deleteLink" value="/deleteVc">
				<c:param name="centerId"
					value="${center.centerId}" />
			</c:url>
			<c:url var="updateLink" value="/updateCall">
				<c:param name="centerId" value="${center.centerId}" />
			</c:url>
			<tr>
				<td>${center.centerId }</td>
				<td>${center.centerName }</td>
				<td>${center.centerCity }</td>
				<td><a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this Center?'))) return false">Delete</a></td>
				<td><a href="${updateLink}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>