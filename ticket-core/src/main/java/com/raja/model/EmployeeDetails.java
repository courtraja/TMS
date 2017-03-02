package com.raja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="employee_details")
@Data
public class EmployeeDetails {

	@Column(name="employee_id")
	
	private int employeeId;
	@Column(name="employee_name")
	
	private String employeeName;
	@Column(name="employee_mail")
	private String employeeMail;
	@Column(name="employee_password")
	private String employeePass;
	@Column(name="employee_active")
	private String employeeActive;
	@Column(name="department_id")
	
    private DepartmentDetails departmentId;
	@Column(name="role_id")
	private role roleId;
	
}
