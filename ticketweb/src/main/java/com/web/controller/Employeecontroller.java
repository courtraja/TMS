package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.exception.ValidationException;
import com.raja.model.DepartmentDetails;
import com.raja.model.EmployeeDetails;
import com.raja.model.role;
import com.raja.service.EmployeeDetailsService;
@Controller
@RequestMapping("/login")
public class Employeecontroller {
	 @GetMapping("/employeelogin") 
	  public String employeelogin(@RequestParam("emailid") String emailid, @RequestParam("password") String pwd,ModelMap modelMap){ 
		 EmployeeDetails employeeDetail=new EmployeeDetails();
		  employeeDetail.setEmployeeMail(emailid);
	   employeeDetail.setEmployeePass(pwd);
	  EmployeeDetailsService employeeDetailService=new EmployeeDetailsService();
	  try{
		  System.out.println("hi");
	  System.out.println(emailid);
	  System.out.println(pwd);
	  employeeDetailService.login(emailid,pwd); 
	 
	  
	  }catch(ValidationException e){
		  e.printStackTrace();
		  modelMap.addAttribute("ERROR_MESSAGE",e.getMessage());
		  return"../employeesLogin.jsp";
	  }
	  return"../successfulemployeelogin.jsp";
	  }
	 @GetMapping("/employeeregistration")
		public String employeeregistration(@RequestParam("employeeid") Integer employeeid,@RequestParam("employeename") String employeename
				,@RequestParam("emailid") String emailid,@RequestParam("password") String password,@RequestParam("department") Integer department,
				@RequestParam("role") Integer role,ModelMap modelMap)throws ValidationException{
			EmployeeDetails employeeDetail=new EmployeeDetails();
			employeeDetail.setEmployeeId(employeeid);
			employeeDetail.setEmployeeName(employeename);
			employeeDetail.setEmployeeMail(emailid);
			employeeDetail.setEmployeePass(password);
			DepartmentDetails depart=new DepartmentDetails();
			depart.setDepartmentId(department);
			employeeDetail.setDepartmentId(depart); 
			role rol=new role();
			rol.setRoleId(role);
			employeeDetail.setRoleId(rol);
			EmployeeDetailsService employeeDetailService=new EmployeeDetailsService();
			try{
				employeeDetailService.save(employeeDetail);
			} catch (ValidationException e) {
				e.printStackTrace();
				modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
				return "../employeeregistration.jsp";
			}
			modelMap.addAttribute("ERROR_MESSAGE","successfully registered");
			return "../index.jsp";
		}
}
