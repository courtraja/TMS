package com.raja.validation;

import com.raja.exception.ValidationException;
import com.raja.model.IssueDetails;
import com.raja.util.ValidationUtil;

public class IssueDetailsValidator {

	public void IssueDetailsvalidation(IssueDetails IssueDetails)throws ValidationException{
		ValidationUtil.isInvalidObject(IssueDetails, "invalid object");
	}
	public void idValidation(int ticketDetails)throws ValidationException{
		ValidationUtil.isInvalidNumber(ticketDetails, "invalid id");
		
	}
	public void ticketValidation(int id)throws ValidationException{
		ValidationUtil.isInvalidNumber(id, "invalid ticket");
		
	}
	public void solutionValidation(String msg)throws ValidationException{
		ValidationUtil.isInvalidString(msg, "invalid solution");
	}
	public void saveValidation(IssueDetails IssueDetails)throws ValidationException{
		idValidation(IssueDetails.getId().getId());
		ticketValidation(IssueDetails.getId().getId());
		solutionValidation(IssueDetails.getSolution());
	}
	public void deleteValidation(IssueDetails IssueDetails)throws ValidationException{
		idValidation(IssueDetails.getId().getId());
	}
	public void updateValidation(IssueDetails IssueDetails )throws ValidationException{
		idValidation(IssueDetails.getId().getId());
		solutionValidation(IssueDetails.getSolution());
	}
}
