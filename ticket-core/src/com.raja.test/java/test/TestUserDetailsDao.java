package com.raja.test;

import java.util.List;

import com.raja.dao.UserDetailsDao;
import com.raja.model.UserDetails;



public class TestUserDetailsDao {

	public static void main(String[] args) {
		UserDetailsDao userDao=new UserDetailsDao();
		//UserDetails detail=new UserDetails();
		
		
		
		
	
//		detail.setUserId(17);
//		detail.setUserMail("gyugfygs@gmail.com");
//		detail.setUserName("hiufgh");
//		detail.setPass("dfjvgbhgsb1335");
//		
//		userDao.save(detail);
		List<UserDetails> list=userDao.list();
		
		for(UserDetails fd:list)
		{
			System.out.println(fd);
		}
		
		
	}
}
