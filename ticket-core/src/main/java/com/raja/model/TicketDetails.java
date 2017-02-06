package com.raja.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketDetails {

	private int id;
	private UserDetails userId;
	private DepartmentDetails departmentId;
	private String subject;
	private String description;
	private EmployeeDetails employeeId;
	private LocalDateTime createdTime;
	private String status;
	private LocalDateTime modifiedTime;
	private int priority;
	
	
}
