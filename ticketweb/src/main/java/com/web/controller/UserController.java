package com.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.exception.ValidationException;
import com.raja.model.EmployeeDetails;
import com.raja.model.UserDetails;
import com.raja.service.EmployeeDetailsService;
import com.raja.service.UserDetailsService;


@Controller
@RequestMapping("/login")
public class UserController {
	@GetMapping("/UserLogin")
	public String userLogin(@RequestParam("email") String emailid, @RequestParam("pwd") String password,
			ModelMap modelMap) {
		System.out.println("hi");
		UserDetails userDetail = new UserDetails();
		userDetail.setUserMail(emailid);
		userDetail.setPass(password);
		System.out.println(userDetail.getUserMail());
		UserDetailsService userDetailService = new UserDetailsService();
		try {
			userDetailService.login(userDetail.getUserMail(), userDetail.getPass());
			System.out.println(userDetail);
		} catch (ValidationException e) {
			
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "../UserLogin.jsp";
		}
		return "../SuccessfulUserLogin.jsp";

	}

	
	  @GetMapping("/employeeLogin") 
	  public String employeelogin(@RequestParam("emailid") String emailid, @RequestParam("password") String password,ModelMap modelMap){ 
		 EmployeeDetails employeeDetail=new EmployeeDetails();
		  employeeDetail.setEmployeeMail(emailid);
	   employeeDetail.setEmployeePass(password);
	  EmployeeDetailsService employeeDetailService=new EmployeeDetailsService();
	  try{
	  employeeDetailService.login(employeeDetail.getEmployeeMail(),employeeDetail.getEmployeePass()); 
	  System.out.println("hi");
	  
	  }catch(ValidationException e){
		  e.printStackTrace();
		  modelMap.addAttribute("ERROR_MESSAGE",e.getMessage());
		  return"../employeeLogin.jsp";
	  }
	  return"../successfulemployeelogin.jsp";
	  }
	@GetMapping("/userregistration")
	public String userRegistration(@RequestParam("userid") Integer userid, @RequestParam("username") String username,
			@RequestParam("emailid") String emailid, @RequestParam("password") String password, ModelMap modelMap) {
		UserDetails userDetail = new UserDetails();
		userDetail.setUserMail(emailid);
		userDetail.setPass(password);
		userDetail.setUserId(userid);
		userDetail.setUserName(username);
		System.out.println(userDetail);
		UserDetailsService userDetailService = new UserDetailsService();
		try {
			userDetailService.registration(userDetail);
		} catch (ValidationException e) {
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "..userregistration/.jsp";

		}
		return "../SuccessfulUserRegistration.jsp";

	}
}