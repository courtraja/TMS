package com.raja.model;

import com.raja.model.role;

import lombok.Data;

@Data
public class EmployeeDetails {

	private int employeeId;
	private String employeeName;
	private String employeeMail;
	private String employeePass;
	private String employeeActive;
	
    private DepartmentDetails departmentId;
	private role roleId;
	
}
