package com.raja.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.raja.dao.IssueDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.IssueDetails;
import com.raja.validation.IssueDetailsValidator;

public class IssueDetailsService {
	@Autowired
private IssueDetailsValidator issueValidator;
final Logger logger = Logger.getLogger(IssueDetails.class.getName());

public void replyToTicket(IssueDetails issue){
	try{
		issueValidator.saveValidation(issue);
		IssueDetailsDao issueDao=new IssueDetailsDao();
		issueDao.save(issue);
		
		issueDao.update(issue);}
	catch(ValidationException e){
		logger.log(Level.SEVERE, "Exception occur", e);
	}
}

}
