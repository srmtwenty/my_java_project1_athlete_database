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

import com.scott.b_springData2_self_project2022a.models.Album;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.services.AlbumService;
import com.scott.b_springData2_self_project2022a.services.UserService;

@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/albums/{id}")
	public String showAlbum(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Album a=albumService.findAlbum(id);
		model.addAttribute("album", a);
		return "showAlbum.jsp";
	}
	@RequestMapping("/albums")
	public String allAlbums(Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		List<Album> albums=albumService.allAlbums();
		model.addAttribute("albums", albums);
		return "allAlbums.jsp";
	}
	
	@RequestMapping("/albums/new")
	public String newAlbum(@ModelAttribute("album") Album album, HttpSession session, Model model) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		return "newAlbum.jsp";
	}
	@RequestMapping(value="/albums/new", method=RequestMethod.POST)
	public String createAlbum(@Valid @ModelAttribute("album") Album album, BindingResult result, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		if(result.hasErrors()) {
			return "newAlbum.jsp";
		}else {
			User host=userService.findUser(loggedId);
			album.setHost(host);
			
			albumService.createAlbum(album);
			System.out.println("Yes!");
			return "redirect:/albums/"+album.getId();
		}
	}
	@RequestMapping("/albums/{id}/edit")
	public String editAlbum(@ModelAttribute("album") Album album, @PathVariable("id") Long id, HttpSession session, Model model){
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Album a=albumService.findAlbum(id);
		model.addAttribute("album", a);
		return "editAlbum.jsp";
	}
	@RequestMapping(value="/albums/{id}/edit", method=RequestMethod.PUT)
	public String updateAlbum(@Valid @ModelAttribute("album") Album album, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}else {
			if(result.hasErrors()) {
				return "editAlbum.jsp";
			}
			User host = userService.findUser(loggedId);
			album.setHost(host);
			
			albumService.updateAlbum(album);
			return "redirect:/albums/"+id;
		}
	}
	
	@RequestMapping(value="/albums/{id}/delete")
	public String deleteAlbum(@PathVariable("id") Long id){
		albumService.deleteAlbum(id);
		return "redirect:/albums";
	}
		
	
}
