package com.raja.validation;

import com.raja.exception.ValidationException;
import com.raja.model.EmployeeDetails;
import com.raja.util.ValidationUtil;


public class EmployeeValidation {

	ValidationUtil validationUtil = new ValidationUtil(); 
	public void employeeValidation(String a,String b,String c,String d)throws ValidationException {
		

		ValidationUtil.isInvalidObject(a, "invalid object");
		ValidationUtil.isInvalidObject(b, "invalid object");
		ValidationUtil.isInvalidObject(c, "invalid object");
		ValidationUtil.isInvalidObject(d, "invalid object");


		}
	public void idValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid id");
	}
	public void nameValidation(String name)throws ValidationException{
		ValidationUtil.isInvalidString(name, "invalid name");
	}
	public void emailValidation(String email)throws ValidationException{
		ValidationUtil.isValidEmail(email, "invalid email");
	}
	public void passwordValidation(String password)throws ValidationException{
		ValidationUtil.isValidPassword(password, "invalid password");
	}
	public void departmentValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid department id");
	}
	public  void statusValidation(Boolean string)throws ValidationException{
		ValidationUtil.isValidBoolean(string, "invalid status");
	}
	public void roleValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid role");
	}
	public void saveValidation(EmployeeDetails emp)throws  ValidationException{
//		employeeValidation(emp);
		idValidation(emp.getEmployeeId());
		nameValidation(emp.getEmployeeName());
		emailValidation(emp.getEmployeeMail());
		passwordValidation(emp.getEmployeePass());
		departmentValidation(emp.getDepartmentId().getDepartmentId());
		
		roleValidation(emp.getRoleId().getRoleId());
	}
	public void deleteValidation(EmployeeDetails emp)throws ValidationException{
//		employeeValidation(emp);
		idValidation(emp.getEmployeeId());
	}
	public void updateValidation(EmployeeDetails emp)throws ValidationException{
//	 employeeValidation(emp);
	 idValidation(emp.getEmployeeId());
	}
}
