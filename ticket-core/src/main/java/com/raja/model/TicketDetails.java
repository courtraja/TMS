package com.raja.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="ticket_details")
public class TicketDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="user_id")
	private UserDetails userId;
	@Column(name="department_id")
	private DepartmentDetails departmentId;
	@Column(name="subject")
	private String subject;
	@Column(name="description")
	private String description;
	@Column(name="assigned_employee")
	private EmployeeDetails employeeId;
	@Column(name="created_time")
	private LocalDateTime createdTime;
	@Column(name="status")
	private String status;
	@Column(name="modified_time")
	private LocalDateTime modifiedTime;
	@Column(name="priority")
	private String priority;
	
	
}
