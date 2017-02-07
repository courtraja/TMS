package com.raja.service;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.raja.dao.UserDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.UserDetails;
import com.raja.validation.UserDetailsValidation;
public class UserDetailsService {
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
	UserDetailsValidation userDetailValidator=new UserDetailsValidation();

	public void registration(UserDetails userDetail) throws ValidationException{
		try{
			userDetailValidator.saveValidation(userDetail);
			UserDetailsDao userDetailDao=new UserDetailsDao();
			userDetailDao.save(userDetail);
		}catch (ValidationException e){
			logger.log(Level.SEVERE, "exception occur %s",e);
			throw e;
		}
	}
public void save(UserDetails userDetail){
	try{
		userDetailValidator.saveValidation(userDetail);
		UserDetailsDao userDetailDao=new UserDetailsDao();
		userDetailDao.save(userDetail);
	}catch (ValidationException e){
		logger.log(Level.SEVERE, "exception occur %s",e);
	}
}
public void delete(UserDetails userDetail){
	try{
		userDetailValidator.deleteValidation(userDetail);
		UserDetailsDao userDetailDao=new UserDetailsDao();
		userDetailDao.delete(userDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}
public void update(UserDetails userDetail){
	try{
		userDetailValidator.updateValidation(userDetail);
		UserDetailsDao userDetailDao=new UserDetailsDao();
		userDetailDao.update(userDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur", e);
	}
}
public void login(String email,String password) throws ValidationException{
	try{
		UserDetailsDao userDetailDao=new UserDetailsDao();
		UserDetails row=(userDetailDao.findone(1));
		String tname=row.getUserMail();
		String tpassword=row.getPass();
		
		String message=(userDetailValidator.loginValidation(tname, tpassword, email, password));
		
		System.out.println(message);
		
		
	}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
		throw e;
	}
}
}
