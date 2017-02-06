package com.raja.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.DepartmentDetails;
import com.raja.util.ConnectionUtil;

public class DepartmentDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(DepartmentDetails department) {

		String sql = "insert into department_details(department_id,department_name) values(?,?)";
		Object[] params = {department.getDepartmentId(),department.getDepartmentName()};
		jdbcTemplate.update(sql, params);
		
		}
	public void update(DepartmentDetails department) {

		String sql = "update department_details set department_name=? where department_id=?";
		Object[] params = {department.getDepartmentName(),department.getDepartmentId()};
		jdbcTemplate.update(sql, params);
		
		}

	public void delete(DepartmentDetails department) {

		String sql = "delete from department_details where department_id=?";
		Object[] params = {department.getDepartmentId()};
		jdbcTemplate.update(sql, params);
		
		}
	
	private DepartmentDetails convert(ResultSet rs) throws SQLException
	{
		
		
			DepartmentDetails department= new DepartmentDetails();
			department.setDepartmentId((rs.getInt("department_id")));
			department.setDepartmentName(rs.getString("department_name"));
			department.setDepartmentActive(rs.getString("department_active"));
			
			return department;
			
		};
	public DepartmentDetails findone()
	{
		String sql = "select * from department_details where department_id=?";
		
		return (DepartmentDetails) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	public List<DepartmentDetails> list()
	{
		String sql = "select * from department_details";
		
		return (List<DepartmentDetails>) jdbcTemplate.query(sql, (rs,rowNum) -> convert(rs));
	}
	
	
}
