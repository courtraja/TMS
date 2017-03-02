package com.raja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="user_details")
@Data
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name="user_name")
	private String UserName;
	@Column(name="user_mail")
	 private String UserMail;
	@Column(name="user_password")
	 private String pass;
	@Column(name="user_active")
	 private boolean active;
	
}
