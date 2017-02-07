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

		String sql = "insert into issue_details(issue_id,ticket_id,solution) values(?,?,?)";
		Object[] params = {issue.getIssueId(),issue.getId(),issue.getSolution()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(IssueDetails issue) {

		String sql = "update IssueDetails set solution=? where issue_id_id=?";
		Object[] params = {issue.getSolution(),issue.getIssueId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(IssueDetails issue) {

		String sql = "delete from issue_details where issue_id=?";
		Object[] params = {issue.getIssueId()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private IssueDetails convert(ResultSet rs) throws SQLException
	{
		
		
		
			
			TicketDetails tick=new TicketDetails();
			tick.setId(rs.getInt("ticket_id"));
		
			IssueDetails issue= new IssueDetails();
			issue.setIssueId(rs.getInt("issue_id"));
			issue.setId(tick);
			issue.setSolution(rs.getString("department_active"));
			
			return issue;
			
		};
	
	public IssueDetails findone(int id)
	{
		String sql = "select * from issue_details where issue_id=?";
		Object[] params={id};
		return (IssueDetails) jdbcTemplate.queryForObject(sql, (rs,rowNum) -> convert(rs));
	}
	public List<IssueDetails> list()
	{
		String sql = "select * from issue_details";
		
		return (List<IssueDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
}
