package com.raja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="employee_details")
@Data
public class DepartmentDetails {

	@Column(name="department_id")
	private int departmentId;

	@Column(name="department_name")
	private String departmentName;
	@Column(name="department_active")
	private String departmentActive;
}
