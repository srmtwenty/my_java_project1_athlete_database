package com.scott.b_springData2_self_project2022a.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.services.UserService;
import com.scott.b_springData2_self_project2022a.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService=userService;
		this.userValidator=userValidator;
	}
	
	@RequestMapping("")
	public String loginRegis(@ModelAttribute("register") User register, @ModelAttribute("login") User login) {
		return "loginRegis.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("register") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginRegis.jsp";
		}else {
			User u=userService.createUser(user);
			session.setAttribute("loggedId", u.getId());
			return "redirect:/home";
		}
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") User user, BindingResult result, HttpSession session) {
		boolean isAuthenticated=userService.authenticationUser(user.getEmail(), user.getPassword());
		if(result.hasErrors()) {
			return "loginRegis.jsp";
		}
		if(isAuthenticated) {
			User u=userService.findByEmail(user.getEmail());
			session.setAttribute("loggedId", u.getId());
			return "redirect:/home";
		}else {
			return "loginRegis.jsp";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
