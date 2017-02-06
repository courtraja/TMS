package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.role;
import com.raja.util.ConnectionUtil;

public class roleDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(role rol) {

		String sql = "insert into role(role_id,roles) values(?,?)";
		Object[] params = {rol.getRoleId(),rol.getRoles()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(role rol) {

		String sql = "update role set roles where role_id=?";
		Object[] params = {rol.getRoles(),rol.getRoleId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(role rol) {

		String sql = "delete from role where role_id=?";
		Object[] params = {rol.getRoleId()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private role convert(ResultSet rs) throws SQLException
	{
		
		
			role role = new role();
			role.setRoleId(rs.getInt("role_id"));
			role.setRoles(rs.getString("roles"));
			
			return role;
			
		};
	
	public role findone()
	{
		String sql = "select * from user_details where user_id=?";
		
		return (role) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<role> list()
	{
		String sql = "select * from user_details";
		
		return (List<role>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	
}
