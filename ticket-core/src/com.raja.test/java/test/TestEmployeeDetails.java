package com.raja.test;

import java.util.List;

import com.raja.dao.EmployeeDetailsDao;
import com.raja.model.EmployeeDetails;

public class TestEmployeeDetails {

	public static void main(String[] args) {
		EmployeeDetailsDao userDao=new EmployeeDetailsDao();
		EmployeeDetails detail=new EmployeeDetails();
		
		
		
		
	
		detail.setEmployeeId(17);
		detail.setEmployeeMail("gyugfygs@gmail.com");
		detail.setEmployeeName("hiufgh");
		detail.setEmployeePass("dfjvgbhgsb1335");
		
		userDao.save(detail);
		List<EmployeeDetails> list=userDao.list();
		
		for(EmployeeDetails fd:list)
		{
			System.out.println(fd);
    }
		
		
	}
}

