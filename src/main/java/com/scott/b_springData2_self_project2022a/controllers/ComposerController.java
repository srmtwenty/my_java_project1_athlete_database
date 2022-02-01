package com.scott.b_springData2_self_project2022a.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scott.b_springData2_self_project2022a.models.Composer;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.services.ComposerService;
import com.scott.b_springData2_self_project2022a.services.UserService;

@Controller
public class ComposerController {
	@Autowired
	private ComposerService composerService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/composers/{id}")
	public String showComposer(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Composer c=composerService.findComposer(id);
		model.addAttribute("composer", c);
		return "showComposer.jsp";
	}
	@RequestMapping("/composers")
	public String allComposers(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host = userService.findUser(loggedId);
		List<Composer> composers=composerService.allComposers();
		model.addAttribute("loggedUser", host);
		model.addAttribute("composers", composers);
		return "allComposers.jsp";
	}
	@RequestMapping("/composers/new")
	public String newComposer(@ModelAttribute("composer") Composer composer, HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "newComposer.jsp";
	}
	@RequestMapping(value="/composers/new", method=RequestMethod.POST)
	public String createComposer(@Valid @ModelAttribute("composer") Composer composer, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host=userService.findUser(loggedId);
		composer.setHost(host);
		composerService.createComposer(composer);
		return "redirect:/composers/"+composer.getId();
	}
	@RequestMapping("/composers/{id}/edit")
	public String editComposer(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		Composer c=composerService.findComposer(id);
		model.addAttribute("composer", c);
		return "editComposer.jsp";
	}
	@RequestMapping(value="/composers/{id}/edit", method=RequestMethod.PUT)
	public String updateComposer(@Valid @ModelAttribute("composer") Composer composer, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User host = userService.findUser(loggedId);
		composer.setHost(host);
		
		composerService.updateComposer(composer);
		return "redirect:/composers/"+id;
	}
	@RequestMapping(value="/composers/{id}/delete")
	public String deleteComposer(@PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		composerService.deleteComposer(id);
		return "redirect:/composers";
	}
}
