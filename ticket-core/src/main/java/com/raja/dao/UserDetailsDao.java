package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.raja.model.UserDetails;
import com.raja.util.ConnectionUtil;

public class UserDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(UserDetails user) {

		String sql = "insert into user_details(user_id,user_name,user_email,user_password) values(?,?,?,?)";
		Object[] params = {user.getUserId(),user.getUserName(),user.getUserMail(),user.getPass()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(UserDetails user) {

		String sql = "update user_details set user_name=?,user_email=?,user_password=? where user_id=?";
		Object[] params = {user.getUserName(),user.getUserMail(),user.getPass(),user.getUserId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(UserDetails user) {

		String sql = "delete from user_details where user_email=?";
		Object[] params = {user.getUserMail()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private UserDetails convert(ResultSet rs) throws SQLException
	{
		
		
			UserDetails user = new UserDetails();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserMail(rs.getString("user_email"));
			user.setPass(rs.getString("user_password"));
			user.setActive(rs.getBoolean("user_active"));
			return user;
			
		};
	
	public UserDetails findone()
	{
		String sql = "select * from user_details where user_id=?";
		
		return (UserDetails) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<UserDetails> list()
	{
		String sql = "select * from user_details";
		
		return (List<UserDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	
}
