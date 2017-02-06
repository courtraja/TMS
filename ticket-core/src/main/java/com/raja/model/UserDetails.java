package com.raja.model;

import lombok.Data;

@Data
public class UserDetails {
	
	private int userId;
	private String UserName;
	 private String UserMail;
	 private String pass;
	 private boolean active;
	
}
