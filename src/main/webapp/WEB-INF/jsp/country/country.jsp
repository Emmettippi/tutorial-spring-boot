<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nazioni</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/country.js"></script>
</head>
<body>
	<c:if test="${loading}">
		Loading...
	</c:if>
	<c:if test="${country}">
		<h3>Modifica Nazione</h3>
	</c:if>
	<button onclick="newCountry()">Nuova Nazione</button>
	<c:if test="${countryList}">
		<h3>Lista delle Nazioni</h3>
		<c:forEach items="${countryList}" var="country">
			<a  href="#" onclick="getCountry(${country.id})">${country.name}</a>
		</c:forEach>
	</c:if>
</body>
</html>