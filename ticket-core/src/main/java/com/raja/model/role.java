package com.raja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="role")
@Data
public class role {
	
	@Column(name="role_id")

	private int roleId;
	@Column(name="roles")
	private String roles;
}
