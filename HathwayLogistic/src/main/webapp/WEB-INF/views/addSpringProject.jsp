<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<core:url value="/add" var="url"></core:url>
<br><br><br>

<center>
<h1>Add Project Details</h1><br><br>
<form:form action="${url}" modelAttribute="project" method="post">
	projectId: <form:input path="projectId"/><br><br>
	projectName: <form:input path="projectName"/><br><br>
	projectOwner: <form:input path="projectOwner"/><br><br>
	projectDuration: <form:input path="projectDuration"/><br><br>
	projectCost: <form:input path="projectCost"/><br><br>
	<input type="submit" value="Save Project" />
</form:form>

</center>
</body>
</html>