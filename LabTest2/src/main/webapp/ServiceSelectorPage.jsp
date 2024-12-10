<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processor 1</title>
</head>
<body bgcolor = "#f0f0f0">
	<h2>Hello ${fname} ${lname}. Your age is: ${age}</h2>

	<form action="ServiceInvokerServlet" method="GET">
  <p>Please select the service you want to invoke:</p>
  <input type="radio" id="s1" name="checked" value="S1">
  <label for="s1">Below The age of 23</label><br>
  <input type="radio" id="s2" name="checked" value="S2">
  <label for="s2">Over The age of 23</label><br>  
  <input type="submit" value="Select Service">
	</form>
</body>
</html>