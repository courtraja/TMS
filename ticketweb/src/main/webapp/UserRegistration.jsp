<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration</title>
</head>
<body align="center">
<form action="login/userregistration" method="GET">
		UserId:<input type="text" name="userid"  /><br><br> 
		UserName:<input type="text" name="username"  /><br><br>
		EmailId:<input type="text" name="emailid"/><br><br>
		Password:<input type="password" name="password" /><br><br>
		<button type="submit">Submit</button>
     </form>
</body>
</html>