package com.eval.coronakit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return  "index";
		
	}
	
	@RequestMapping("/home")
	public String home() {
		return  "main-menu";
	}
	
	@RequestMapping("/header")
	public String showHeader() {
		return "header";
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegister() {
		return new ModelAndView("register", "userDetails", new User());
	}
	
	
}
