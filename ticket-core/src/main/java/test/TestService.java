package test;

import java.time.LocalDateTime;


import com.raja.dao.TicketDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.IssueDetails;
import com.raja.model.TicketDetails;
import com.raja.model.UserDetails;
import com.raja.service.IssueDetailsService;
import com.raja.service.TicketDetailsService;
import com.raja.service.UserDetailsService;

public class TestService {

	public static void main(String[] args) {
		UserDetailsService userDetailService=new UserDetailsService();

	//testLogin();
//	 testRegistration();
//		testUpdate();
//testCloseTicket();
		// testViewTicket();
		//testAssignTicket();
		//testReplysolution();
        //  testReassign();
	//	testDeleteTicket();
 ticketCreation();
		}

static void testLogin() {
	UserDetailsService userDetailService=new UserDetailsService();
	try {
		userDetailService.login("syu@gmail.com", "yuvardn");
	} catch (ValidationException e) {	
		e.printStackTrace();
	} 
}
static void testRegistration() {
	UserDetailsService userDetailService=new UserDetailsService();

	UserDetails userDetail=new UserDetails();
	userDetail.setUserId(2);
	userDetail.setUserMail("raja@gmail.com");
	userDetail.setUserName("raja");;
	userDetail.setPass("raja12345");;
try {
	userDetailService.registration(userDetail);
} catch (ValidationException e) {
	e.printStackTrace();
}
	
}
static void ticketCreation(){
	TicketDetails ticketDetail=new TicketDetails();
	ticketDetail.setId(1);
	UserDetails userDetail=new UserDetails();
	userDetail.setUserId(1);
	ticketDetail.setUserId(userDetail);
	DepartmentDetails department=new DepartmentDetails();
	department.setDepartmentId(1);
	ticketDetail.setDepartmentId(department);
	ticketDetail.setSubject("ndnjd");
	ticketDetail.setDescription("hjdhhjd");
	ticketDetail.setCreatedTime(LocalDateTime.now());
	ticketDetail.setPriority("high");
	TicketDetailsService ticketDetailService=new TicketDetailsService();
	ticketDetailService.createTicket(ticketDetail);
}
 static void  testUpdate(){
	 TicketDetailsService ticketDetailService=new TicketDetailsService();
	 TicketDetails ticketDetail=new TicketDetails();
	 ticketDetail.setId(1);
	 ticketDetail.setSubject("something");
     UserDetails userDetail=new UserDetails();
     userDetail.setUserId(1);
     ticketDetail.setUserId(userDetail);
	 ticketDetailService.update(ticketDetail);
 }
static void testCloseTicket(){
	TicketDetailsService ticketDetailService=new TicketDetailsService();
	TicketDetails ticketDetail=new TicketDetails();
	ticketDetail.setId(1);
	ticketDetailService.close(ticketDetail);
}
static void testViewTicket(){
	TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
	System.out.println(ticketDetailDao.select(1));
}
static void testAssignTicket(){
	TicketDetailsService ticketDetailService=new TicketDetailsService();
	TicketDetails ticketDetail=new TicketDetails();
	ticketDetail.setId(1);
	EmployeeDetails employeeDetail =new EmployeeDetails();
	employeeDetail.setEmployeeId(1);
	ticketDetail.setModifiedTime(LocalDateTime.now());
	ticketDetail.setEmployeeId(employeeDetail);
	
	ticketDetailService.assignTicket(ticketDetail);
}
static void testReplysolution(){
IssueDetailsService issueService=new IssueDetailsService();
IssueDetails issue=new IssueDetails();
issue.setIssueId(1);
TicketDetails ticketDetail=new TicketDetails();
ticketDetail.setId(1);
issue.setId(ticketDetail);
issue.setSolution("can be solved");
issueService.replyToTicket(issue);
}
static void testReassign(){
	TicketDetailsService ticketDetailService=new TicketDetailsService();
	TicketDetails ticketDetail=new TicketDetails();
	ticketDetail.setId(1);
	EmployeeDetails employeeDetail =new EmployeeDetails();
	employeeDetail.setEmployeeId(1);
	ticketDetail.setModifiedTime(LocalDateTime.now());
	ticketDetail.setEmployeeId(employeeDetail);
	
	ticketDetailService.updateReassign(ticketDetail);
}
static void testDeleteTicket(){
	TicketDetailsService ticketDetailService=new TicketDetailsService();
	TicketDetails ticketDetail=new TicketDetails();
	ticketDetail.setId(1);
	UserDetails userDetail=new UserDetails();
	userDetail.setUserId(1);
	ticketDetail.setUserId(userDetail);

	ticketDetailService.delete(ticketDetail);
}
}
