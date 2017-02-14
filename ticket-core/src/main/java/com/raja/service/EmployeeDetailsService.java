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
	EmployeeValidation employeeDetailValidator = new EmployeeValidation();
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());

	public void save(EmployeeDetails employee) throws ValidationException {
		try {
			employeeDetailValidator.saveValidation(employee);
			EmployeeDetailsDao employeeDetailDao = new EmployeeDetailsDao();
			employeeDetailDao.save(employee);
		} catch (ValidationException e) {
			logger.log(Level.SEVERE, "exception occur", e);
			throw e;
		}
	}

	public void delete(EmployeeDetails employee) {
		try {
			employeeDetailValidator.deleteValidation(employee);
			EmployeeDetailsDao employeeDetailDao = new EmployeeDetailsDao();
			employeeDetailDao.delete(employee);
		} catch (ValidationException e) {
			logger.log(Level.CONFIG, "exception occur", e);
		}
	}

	public void login(String email, String password) throws ValidationException {

		try {
			System.out.println("hi");
			EmployeeValidation employeevalidator = new EmployeeValidation();
			System.out.println("hi");

			EmployeeDetailsDao dao = new EmployeeDetailsDao();
			System.out.println("hlo");

			EmployeeDetails findone = dao.findone(email);
			System.out.println(findone.getEmployeeMail());
	
			System.out.println("hlo");

//			System.out.println(row.getEmployeeMail());
			String tname = findone.getEmployeeMail();
			String tpassword = findone.getEmployeePass();
			System.out.println(tname);
//			System.out.println(row.getEmployeeMail());
			employeevalidator.employeeValidation(tname, tpassword, email, password);

		} catch (ValidationException e) {
			logger.log(Level.SEVERE, "exception occur", e);
			throw e;

		}

	}
}
