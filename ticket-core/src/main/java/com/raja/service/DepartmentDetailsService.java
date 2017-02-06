package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.raja.dao.DepartmentDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.validation.DepartmentDetailsValidator;





public class DepartmentDetailsService {

	public class DepartmentService {
		public void save(DepartmentDetails department){
			DepartmentDetailsValidator DepartmentDetailsValidation=new DepartmentDetailsValidator();
			final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
			try{
				DepartmentDetailsValidation.saveValidation(department);
				DepartmentDetailsDao  departmentDao=new DepartmentDetailsDao();
				departmentDao.save(department);
			}catch (ValidationException e){
				logger.log(Level.SEVERE, "exception occur %s", e);
			}
		}
		public void delete(DepartmentDetails department){
			DepartmentDetailsValidator DepartmentDetailsValidation=new DepartmentDetailsValidator();
			final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
			try{
				DepartmentDetailsValidation.deleteValidation(department);
				DepartmentDetailsDao  departmentDao=new DepartmentDetailsDao();
				departmentDao.delete(department);
			}catch (ValidationException e){
				logger.log(Level.SEVERE, "exception occur %s", e);
			}
		}
		}

}
