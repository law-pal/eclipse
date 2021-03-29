package com.tekglobalspringproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tekglobalspringproject.models.User;



@RequestMapping("/admin")
@Controller
public class HomeController {
	
	

	@RequestMapping("/")
	public ModelAndView welcome (){
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processInput(@RequestParam("name") String name,
			@RequestParam("email" )String email) {
		User user = new User(name, email);
		System.out.println(user.toString());
		return "index";
	}
	
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		System.out.println(user.toString());
		return "login";
	}
	
}
