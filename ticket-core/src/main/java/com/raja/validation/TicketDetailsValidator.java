package com.raja.validation;

import java.time.LocalDateTime;

import com.raja.exception.ValidationException;
import com.raja.model.EmployeeDetails;
import com.raja.model.TicketDetails;
import com.raja.util.ValidationUtil;

public class TicketDetailsValidator {

	public void ticketValidation(TicketDetails ticket)throws ValidationException{
		ValidationUtil.isInvalidObject(ticket, "object is empty");
	}
	public void idvalidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid id");
	}
	public void userValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid user id");
	}
	public void departmentValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid department");
	}
	public void subjectValidation(String name)throws ValidationException{
		ValidationUtil.isInvalidString(name, "invalid subject");
	}
	public void descriptionValidation(String name)throws ValidationException{
		ValidationUtil.isInvalidString(name, "invalid description");
	}
	public void employeeValidation(Integer id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid employee");
	}
	public void timeValidation(LocalDateTime num)throws ValidationException{
		ValidationUtil.isValidDateTime(num, "invalid timestramp");
	}
	public void statusValidation(String name)throws ValidationException{
		ValidationUtil.isInvalidString(name, "invalid status");
	}
	public void adminValidation(EmployeeDetails employeeDetail)throws ValidationException{
		ValidationUtil.isInvalidObject(employeeDetail, "employee is not ia admin");
	}

	public void saveValidation(TicketDetails ticket)throws ValidationException{
		ticketValidation(ticket);
		idvalidation(ticket.getId());
		userValidation(ticket.getUserId().getUserId());
		departmentValidation(ticket.getDepartmentId().getDepartmentId());
		subjectValidation(ticket.getSubject());
	   descriptionValidation(ticket.getDescription());
	   employeeValidation(ticket.getEmployeeId().getEmployeeId());
	   timeValidation(ticket.getCreatedTime());
	   timeValidation(ticket.getModifiedTime());
	   statusValidation(ticket.getStatus());
	   
	}
	public void createTicketValidation(TicketDetails ticket)throws ValidationException{
		ticketValidation(ticket);
		idvalidation(ticket.getId());
		userValidation(ticket.getUserId().getUserId());
		departmentValidation(ticket.getDepartmentId().getDepartmentId());
		subjectValidation(ticket.getSubject());
	   descriptionValidation(ticket.getDescription());
	   timeValidation(ticket.getCreatedTime());
	   
	   
	}
	public void deleteValidation(TicketDetails ticket)throws ValidationException{
		idvalidation(ticket.getId());
		userValidation(ticket.getUserId().getUserId());
	}
	public void updateValidation(TicketDetails ticket)throws ValidationException{
		idvalidation(ticket.getId());
		subjectValidation(ticket.getSubject());
	}
	public void closeticketValidation(TicketDetails ticket)throws ValidationException{
		idvalidation(ticket.getId());
		
	}
	public void assignTicketValidation(TicketDetails ticket)throws ValidationException{
		idvalidation(ticket.getId());
		employeeValidation(ticket.getId());
	}
	public void deleteTicketAssign(EmployeeDetails row)throws ValidationException{
		adminValidation(row);
		}
	public void employeeValidation(EmployeeDetails row)throws ValidationException{
		adminValidation(row);
	}
}
