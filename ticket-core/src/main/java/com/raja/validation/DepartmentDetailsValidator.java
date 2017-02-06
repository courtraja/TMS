
package com.raja.validation;

import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.util.ValidationUtil;

public class DepartmentDetailsValidator {

	public void validDepartment(DepartmentDetails department)throws ValidationException{
		  ValidationUtil.isInvalidObject(department, "empty object");
	  }
	  public void idValidation(Integer id)throws ValidationException{
		  ValidationUtil.isInvalidNumber(id, "invalid id");
	  }
	  public void namevalidation(String name)throws ValidationException{
		  ValidationUtil.isInvalidString(name, "invalid name");
	  }public void statusValidation(Boolean string)throws ValidationException{
		  ValidationUtil.isValidBoolean(string, "invalid status");
	  }
	  public void saveValidation(DepartmentDetails department)throws ValidationException{
		  validDepartment(department);
		  idValidation(department.getDepartmentId());
		  namevalidation(department.getDepartmentName());
		  
	  }
	  public void deleteValidation(DepartmentDetails department)throws ValidationException{
		  validDepartment(department);
		  idValidation(department.getDepartmentId());
	  }
}



