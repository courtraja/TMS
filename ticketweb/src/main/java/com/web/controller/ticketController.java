package com.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.dao.TicketDetailsDao;
import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.TicketDetails;
import com.raja.model.UserDetails;
import com.raja.service.TicketDetailsService;

@Controller
@RequestMapping("/ticket")
public class ticketController {
	
	

		@GetMapping("/viewticket")
		public String viewTicket(@RequestParam("userId") int userId, ModelMap modelMap) {
			TicketDetailsDao ticketDetailDao = new TicketDetailsDao();
			List<TicketsDetail> t = ticketDetailDao.ticketview(userId);
			modelMap.addAttribute("Error_Message", t);
			return "../viewticket.jsp";
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
		}catch(ValidationException e){
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e);
			return "../closeticket.jsp";
		}
		return "../viewticket.jsp";
		}

		@GetMapping("/createticket")
		public String createticket(@RequestParam("ticketid") Integer ticketid, @RequestParam("userid") Integer userid,
				@RequestParam("department") Integer department, @RequestParam("subject") String subject,
				@RequestParam("description") String description, @RequestParam("priority") String priority,
				ModelMap modelMap) {
			System.out.println(userid + "" + department);
			TicketDetails ticketDetail = new TicketDetails();
			ticketDetail.setId(ticketid);
			UserDetails userDetail = new UserDetails();
			userDetail.setUserId(userid);
			ticketDetail.setUserId(userDetail);
			DepartmentDetails department2 = new DepartmentDetails();
			department2.setDepartmentId(department);
			ticketDetail.setDepartmentId(department2);
			ticketDetail.setSubject(subject);
			ticketDetail.setDescription(description);
			ticketDetail.setPriority(priority);
			ticketDetail.setCreatedTime(LocalDateTime.now());
			System.out.println("hi");
			modelMap.addAttribute("variable", userid);
			try {
				TicketDetailsService ticketDetailService = new TicketDetailsService();
				ticketDetailService.createTicket(ticketDetail);
			} catch (ValidationException e) {
				e.printStackTrace();
				modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
				return "../createticket.jsp";
			}
			return "../viewticket.jsp";

		}
		@GetMapping("/updateticket")
		
		public String updateticket(@RequestParam("ticketid") Integer ticketid,@RequestParam("subject") String subject,ModelMap modelMap){
			TicketDetails ticketDetail=new TicketDetails();
			ticketDetail.setId(ticketid);
			ticketDetail.setSubject(subject);
			TicketDetailsService ticketDetailService=new TicketDetailsService();
			try{
				ticketDetailService.update(ticketDetail);
				TicketDetailsDao ticketDetailDao=new TicketDetailsDao();
				ticketDetailDao.update(ticketDetail.getDescription(),ticketDetail.getId());
				modelMap.addAttribute("variable", ticketDetail.getUserId());
			}
			catch(ValidationException e){
				e.printStackTrace();
				modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
				return "../updateticket.jsp";
			}
			return "../viewticket.jsp";
		}
	
}
