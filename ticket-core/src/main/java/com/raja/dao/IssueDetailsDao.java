package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.raja.model.IssueDetails;
import com.raja.model.TicketDetails;
import com.raja.util.ConnectionUtil;

public class IssueDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(IssueDetails issue) {

		String sql = "insert into issue_details(ticket_id,solution) values(?,?,?)";
		Object[] params = {issue.getId(),issue.getSolution()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(IssueDetails issue) {

		String sql = "update IssueDetails set solution=? where ticket_id=?";
		Object[] params = {issue.getSolution(),issue.getId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(IssueDetails issue) {

		String sql = "delete from issue_details where ticket_id=?";
		Object[] params = {issue.getId()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private IssueDetails convert(ResultSet rs) throws SQLException
	{
		
		
		
			
			TicketDetails tick=new TicketDetails();
			tick.setId(rs.getInt("ticket_id"));
		
			IssueDetails issue= new IssueDetails();
			
			issue.setId(tick);
			issue.setSolution(rs.getString("department_active"));
			
			return issue;
			
		};
	
	public IssueDetails findone()
	{
		String sql = "select * from issue_details where user_id=?";
		
		return (IssueDetails) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<IssueDetails> list()
	{
		String sql = "select * from issue_details";
		
		return (List<IssueDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
}
