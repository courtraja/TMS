package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

import com.raja.dao.TicketDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.mail.Mail;
import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.TicketDetails;
import com.raja.validation.TicketDetailsValidator;

public class TicketDetailsService {
    @Autowired
	private TicketDetailsValidator ticketDetailValidator;
	final Logger logger = Logger.getLogger(DepartmentDetails.class.getName());
	@Autowired
	private TicketDetailsDao ticketDetailDao;
public void save(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.saveValidation(ticketDetail);
		
		ticketDetailDao.save(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE,"exception occur",e);
	}
}
public void delete(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.deleteValidation(ticketDetail);
		
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
		
		ticketDetailDao.update(ticketDetail);
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void createTicket(TicketDetails ticketDetail) throws ValidationException,EmailException{
	try{
		ticketDetailValidator.createTicketValidation(ticketDetail);
		
		ticketDetailDao.createticket(ticketDetail);
		Mail.sendSimpleMail("courtjes1995@gmail.com","Ticket Created Sucessfully.Your Ticket id is:",ticketDetail.getId());

	}catch(ValidationException e){
		logger.log(Level.SEVERE,"Exception occur", e);
	}
}
@Autowired
private DepartmentDetails department;
public void assignTicket(TicketDetails ticketDetail ){
	try{
		ticketDetailValidator.assignTicketValidation(ticketDetail);
		
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
		ticketDetailDao.reassignTicket(ticketDetail.getId(), ticketDetail.getEmployeeId().getEmployeeId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
		}
}
public void close(TicketDetails ticketDetail){
	try{
		ticketDetailValidator.closeticketValidation(ticketDetail);
		ticketDetailDao.closeTicket(ticketDetail.getId());
	}catch(ValidationException e){
		logger.log(Level.SEVERE, "exception occur", e);
	}
}

}
