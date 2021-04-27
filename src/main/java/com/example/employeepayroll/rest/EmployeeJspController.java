package com.example.employeepayroll.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employeepayroll.service.ServiceInterface;

@Controller
public class EmployeeJspController {
	
	@Autowired
	private ServiceInterface service;
	
	@GetMapping("/loginPage")
	public String getloginPage() {
		
		return "loginpage";
	}
	
	
	@GetMapping("/signUp")
	public String getSignUpPage() {		
		return "signUp";
	}
	
	@RequestMapping("/home")
	public String getHomePage(HttpServletRequest request,Model model) {	
		
		String message=request.getParameter("UserName");

		message="Welcome "+message+"!";
		
		model.addAttribute("greetMessage",message);
		
		return "home";
	}
	
	

}
