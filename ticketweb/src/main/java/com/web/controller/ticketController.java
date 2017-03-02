package com.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.dao.TicketDetailsDao;
import com.raja.model.DepartmentDetails;
import com.raja.model.TicketDetails;
import com.raja.model.UserDetails;
import com.raja.service.TicketDetailsService;

@Controller
@RequestMapping("/ticket")
public class ticketController {
	
	

		@GetMapping("/ViewTicket")
		public String viewTicket(@RequestParam("userId") int userId, ModelMap modelMap) {
			
			TicketDetailsDao ticketDetailDao = new TicketDetailsDao();
			List<TicketDetails> t = ticketDetailDao.viewticket(userId);
			modelMap.addAttribute("list",t);
			modelMap.addAttribute("Error_Message", t);
			return "../ViewTicket.jsp";
		}
		@GetMapping("/closeticket")  
		
		public String closeticket(@RequestParam("ticketid") int ticketid,ModelMap modelMap){
			
			TicketDetails ticketDetail=new TicketDetails();
			ticketDetail.setId(ticketid);
			System.out.println("hi");
		TicketDetailsService ticketDetailService=new TicketDetailsService();
		try{
		ticketDetailService.close(ticketDetail);
		TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
		ticketDetailDao.closeTicket(ticketDetail.getId());
		}catch(Exception e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../closeticket.jsp";
		}
		return "../ViewTicket.jsp";
		}

		@GetMapping("/CreateTicket")
		@Autowired
		public String createticket(@RequestParam("ticket_id") Integer ticketid, @RequestParam("user_id") Integer userid,
				@RequestParam("department_id") Integer department, @RequestParam("subject") String subject,
				@RequestParam("description") String description, @RequestParam("priority") String priority,
				ModelMap modelMap) {
			System.out.println(userid + "" + department);
			TicketDetails ticketDetail = new TicketDetails();
			System.out.println(ticketid);
			ticketDetail.setId((ticketid));
			
			UserDetails userDetail = new UserDetails();
			userDetail.setUserId(userid);
			ticketDetail.setUserId(userDetail);
			DepartmentDetails dept = new DepartmentDetails();
			dept.setDepartmentId(department);
			ticketDetail.setDepartmentId(dept);
			ticketDetail.setSubject(subject);
			ticketDetail.setDescription(description);
			ticketDetail.setPriority(priority);
		
			System.out.println("hi");
			modelMap.addAttribute("variable", userid);
			try {
				TicketDetailsService ticketDetailService = new TicketDetailsService();
				ticketDetailService.createTicket(ticketDetail);
			} 
			catch(Exception e){
				e.printStackTrace();
				modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
				return "../CreateTicket.jsp";
			}
			return "../ViewTicket.jsp";

		}
		@GetMapping("/updateticket")
		
		public String updateticket(@RequestParam("ticketid") Integer ticketid,@RequestParam("description") String description,ModelMap modelMap){
			TicketDetails ticketDetail=new TicketDetails();
			ticketDetail.setId(ticketid);
			ticketDetail.setDescription(description);
			TicketDetailsService ticketDetailService=new TicketDetailsService();
			try{
				ticketDetailService.update(ticketDetail);
				TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
				ticketDetailDao.update(ticketDetail);
				modelMap.addAttribute("variable", ticketDetail.getUserId());
			}
			catch(Exception e){
				e.printStackTrace();
				modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
				return "../updateticket.jsp";
			}
			return "../ViewTicket.jsp";                               
		}
	
}
