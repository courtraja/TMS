package com.raja.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.TicketDetails;
import com.raja.model.UserDetails;
import com.raja.util.ConnectionUtil;

public class TicketDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(TicketDetails ticket) {

		String sql = "insert into ticket_details(user_id,subject,description,assigned_employee) values(?,?,?,?)";
		Object[] params = {ticket.getUserId(),ticket.getSubject(),ticket.getDescription(),ticket.getEmployeeId()};
		jdbcTemplate.update(sql, params);
		
		}
	public int createticket(TicketDetails ticketDetail){
		String sql="insert into ticket_details(id,user,department,subject,description,created_time,priority )values(?,?,?,?,?,?,?)";
		Object[] params={ticketDetail.getId(),ticketDetail.getUserId().getUserId(),ticketDetail.getDepartmentId(),ticketDetail.getSubject(),ticketDetail.getDescription(),ticketDetail.getCreatedTime(),ticketDetail.getPriority()};
	   return jdbcTemplate.update(sql,params);
	}
	public void update(TicketDetails ticket) {

		String sql = "update ticket_details set description=? where user_id=?";
		Object[] params = {ticket.getDescription(),ticket.getUserId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(TicketDetails ticket) {

		String sql = "delete from ticket_details where user_id=?";
		
		Object[] params = {ticket.getId()};
		jdbcTemplate.update(sql, params);
		
		}
	public int closeTicket(int id){
		String sql="update ticket_details set status=? where id=?";
		Object[] params={"closed",id};
		return jdbcTemplate.update(sql,params);
	}
	public int assignTicket(int ticketId,int employeeId ,LocalDateTime time){
		String sql="update ticket_details set assigned_to=?,modified_time=?,status=? where id=? and status=?";
		Object[] params={employeeId,time,"inprogress",ticketId,"open"};
		return jdbcTemplate.update(sql,params);
	}
	public int reassignTicket(int ticketId,int employeeId ){
		String sql="update ticket_details set assigned_to=? where id=? ";
		Object[] params={employeeId,ticketId};
		return jdbcTemplate.update(sql,params);
	}
	
	private TicketDetails convert(ResultSet rs) throws SQLException
	{
		
		
			
			UserDetails user=new UserDetails();
			user.setUserId(rs.getInt("user_id"));
			TicketDetails ticket1=new TicketDetails();
			EmployeeDetails employ=new EmployeeDetails();
			employ.setEmployeeId(rs.getInt("assigned_employee"));
			
			DepartmentDetails dept=new DepartmentDetails();
			dept.setDepartmentId(rs.getInt("department_id"));
			
			
			ticket1.setId(rs.getInt("id"));
			ticket1.setUserId(user);
			ticket1.setDepartmentId(dept);
			ticket1.setSubject(rs.getString("subject"));
			ticket1.setDescription(rs.getString("description"));
			ticket1.setEmployeeId(employ);
			ticket1.setCreatedTime((rs.getTimestamp("created_time")).toLocalDateTime());
			ticket1.setStatus(rs.getString("status"));
			ticket1.setPriority(rs.getInt("priority"));
			ticket1.setModifiedTime(rs.getTimestamp("modified_time").toLocalDateTime());
			return ticket1;
			
		};
	
	public TicketDetails select(int userId)
	{
		String sql = "select select * from TicketDetails where user_id=?";
		
		return (TicketDetails) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<TicketDetails> list()
	{
		String sql = "select select * from TicketDetails";
		
		return (List<TicketDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public EmployeeDetails checkadmin (int id)
	{
		
	
		String sql="select id from seed_employee_details where id=? and role=(select id from seed_role where name=?)";
		Object[] params={id,"admin"};
		return (EmployeeDetails) jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
			EmployeeDetails employeeDetail=new EmployeeDetails();
			employeeDetail.setEmployeeId(rs.getInt("id"));
			return employeeDetail;
		});
		
	}
	public EmployeeDetails checkEmployee(int id,String name)
	{
		String sql="select id from seed_employee_details where id=? and department=(select id from seed_department where name=?";
		Object[] params={id,name};
		return jdbcTemplate.queryForObject(sql,params,(rs,rownum)->{
			EmployeeDetails employeeDetail=new EmployeeDetails();
			employeeDetail.setEmployeeId(rs.getInt("id"));
			return employeeDetail;
		});
	}
	
}