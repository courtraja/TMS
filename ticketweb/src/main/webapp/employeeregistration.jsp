<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${ERROR_MESSAGE}</h2>
      <form action="/login/employeeregistration">
		    Employee Id : <input type="text" name="employeeid"  /> 
		    Name : <input type="text" name="employeename"  />
			EmailId:<input type="text" name="emailid"/>
			Password:<input type="password" name="password" />
			Department:<select name="department">
		<option value="1">human resource</option>
		<option value="2">information technology</option>
		<option value="3">finance</option></select>
			roles:<select name="role">
		<option value="1">admin</option>
		<option value="2">manager</option>
		<option value="3">TL</option></select>
		<button type="submit">Submit</button>
     </form>
</body>
</html>