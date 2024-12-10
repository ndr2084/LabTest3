<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor = "#f0f0f0">
<h1>
The result from Service is: <br> ${serviceResult}
</h1>
<form action="WelcomeServlet" method= "GET">
<Button type="submit" name ="restart" value = "True">Re-Compute</Button> 
</form>
</body>
</html>