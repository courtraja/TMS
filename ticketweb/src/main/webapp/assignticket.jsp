<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Assign Ticket</h1>
<center>
<div style="text-align:center;">

<form action="/ticket/assignticket" method="get">
Ticket Id  :<input type="number" name="ticketid" /></br>
Employee Id:<input type="number" name="employeeid" /></br>
 <button type="submit">Submit</button>

</form>
<center>
  <a href="../ViewTicket.jsp">View Ticket</a></br>
  <a href="../ReplyTicket.jsp">Reply Ticket</a></br>
  <a href="../ReassignTicket.jsp">Reassign Ticket</a>
  <a href="../index.jsp">Logout</a>
  </center>
</div>
</center>
</body>
</body>
</html>