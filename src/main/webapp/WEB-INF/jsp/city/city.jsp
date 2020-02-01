<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/city.js"></script>
<body>
	<c:if test="${loading}">
		Loading...
	</c:if>
	<c:if test="${city}">
		<h3>Modifica Città</h3>
	</c:if>
	<c:if test="${cityList}">
		<h3>Lista delle Città</h3>
	</c:if>
</body>
</html>