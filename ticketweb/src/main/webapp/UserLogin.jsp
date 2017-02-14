<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
${ERROR_MESSAGE};
<br>
<br>
<br>
<br>
<form action="login/UserLogin" method="GET">
		<div class="form-group" align="center">
      <label for="email">Email:</label>
      <input type="text" class="form-control" name="email" placeholder="Username" style="width:300px">
    </div>
    <div class="form-group" align="center">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" placeholder=" password" style="width:300px">
    </div>
    <center><button type="submit" class="btn btn-default">Login</button></center><br><br>
    

	</form>
</body>
</html>