package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.raja.dao.EmployeeDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.validation.EmployeeValidation;
import com.raja.validation.UserDetailsValidation;


public class EmployeeDetailsService {
 EmployeeValidation employeeDetailValidator=new EmployeeValidation();
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());

 public void save(EmployeeDetails employee){
	 try{
		 employeeDetailValidator.saveValidation(employee);
		 EmployeeDetailsDao employeeDetailDao=new EmployeeDetailsDao();
		 employeeDetailDao.save(employee);
	 }catch(ValidationException e){
		 logger.log(Level.SEVERE, "exception occur",e);
	 }
 }
 public void delete(EmployeeDetails employee){
	 try{
		 employeeDetailValidator.deleteValidation(employee);
		 EmployeeDetailsDao employeeDetailDao=new EmployeeDetailsDao();
		 employeeDetailDao.delete(employee);
	 }catch (ValidationException e){
		 logger.log(Level.CONFIG,"exception occur",e);
	 }
 }
 public void  login(String email,String password) throws ValidationException{
		
		try{
			UserDetailsValidation userDetailValidator=new UserDetailsValidation();
		 EmployeeDetailsDao employeeDetailDao=new EmployeeDetailsDao();
		EmployeeDetails row	=employeeDetailDao.findone();
			String tname=row.getEmployeeMail();
			String tpassword=row.getEmployeePass();
			System.out.println(tname);
			userDetailValidator.loginValidation(tname, tpassword, email, password);
			
			
		}
		catch(ValidationException e){
			logger.log(Level.SEVERE, "exception occur", e);
		     throw e;
		
		}
		
	    
	    
	}
}

