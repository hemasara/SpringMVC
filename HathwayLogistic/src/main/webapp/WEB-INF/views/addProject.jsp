<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<br><br><br>
<center>
<form action="/HathwayLogistic/add" method="post">
	projectId: <input type="text" name="projectId" /><br><br>
	projectName: <input type="text" name="projectName" /><br><br>
	projectOwner: <input type="text" name="projectOwner" /><br><br>
	projectDuration: <input type="text" name="projectDuration" /><br><br>
	projectCost: <input type="text" name="projectCost" /><br><br>
	<input type="submit" value="AddProject" />	
</form>
</center>
</body>
</html>