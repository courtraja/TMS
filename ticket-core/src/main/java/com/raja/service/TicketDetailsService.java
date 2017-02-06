package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.raja.dao.TicketDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.TicketDetails;
import com.raja.validation.TicketDetailsValidator;

public class TicketDetailsService {

	TicketDetailsValidator ticketDetailValidator=new TicketDetailsValidator();
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
public void save(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.saveValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.save(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void delete(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.deleteValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		EmployeeDetails row =ticketDetailDao.checkadmin(ticketDetail.getUserId().getUserId());
	     ticketDetailValidator.deleteTicketAssign(row);
			
		ticketDetailDao.delete(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void update(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.updateValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.update(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void createTicket(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.createTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.createticket(ticketDetail);
		
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
public void assignTicket(TicketDetails ticketDetail ){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		DepartmentDetails department=new DepartmentDetails();
		EmployeeDetails row=ticketDetailDao.checkEmployee(ticketDetail.getUserId().getUserId(),department.getDepartmentName());
		ticketDetailValidator.employeeValidation(row);
		ticketDetailDao.assignTicket(ticketDetail.getId(), ticketDetail.getId(),ticketDetail.getModifiedTime());
	}catch(ValidationException e)
	{
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
public void updateReassign(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.reassignTicket(ticketDetail.getId(), ticketDetail.getEmployeeId().getEmployeeId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void close(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.closeticketValidation(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.closeTicket(ticketDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}

}
