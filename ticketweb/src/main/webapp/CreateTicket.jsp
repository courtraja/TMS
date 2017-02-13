<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Ticket Generation</h1>
        <form action="ticket/CreateTicket" method="GET">
		Ticket Id : <input type="number" name="ticket_id" /> 
		User Id : <input type=" number" name="user_id" />
		Department:<select name="department_id">
		<option value="1">human resource</option>
		<option value="2">information technology</option>
		<option value="3">finance</option></select>
		Subject:<input type="text" name="subject" />
		Description:<input type="text" name="description" />
		Priority:<select name="priority">
		<option value="high">high</option>
		<option value="low">low </option>
		<option value="medium">medium</option></select>
		
		
		<button type="submit">Submit</button>

	</form>
	ViewTicket :<a href="../ViewTicket.jsp">ViewTicket</a></br>
	UpdateTicke:<a href="../updateticket.jsp">updateticket</a></br>
	CloseTicket :<a href="../closeticket.jsp">closeticket</a></br>
  
	${ERROR_MESSAGE};
</body>
</html>