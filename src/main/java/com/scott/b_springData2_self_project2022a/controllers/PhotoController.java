package com.scott.b_springData2_self_project2022a.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.services.SwimmerService;
import com.scott.b_springData2_self_project2022a.services.UserService;
import com.scott.b_springData2_self_project2022a.util.FileUploadUtil;


@Controller
public class PhotoController {
	@Autowired
	private SwimmerService swimmerService;
	@Autowired
	private UserService userService;
	
	@Value("${upload.path}")
	private String uploadDir;
	
	@PostMapping("/photo/pic/{id}")
	public String submitPhoto(@PathVariable("id") Long id, @RequestParam("image") MultipartFile multipartFile, Model model, HttpSession session) {
		Long loggedId=(Long) session.getAttribute("loggedId");
		if(loggedId==null) {
			return "redirect:/logout";
		}
		User u=userService.findUser(loggedId);
		model.addAttribute("loggedUser", u);
		
		Swimmer swimmer=swimmerService.findSwimmer(id);
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Path path=Paths.get(uploadDir, "swimmerphotos/"+swimmer.getId());
		
		//swimmer.setPhotos(fileName);
		
		//Swimmer savedSwimmer = swimmerService.updateSwimmer(swimmer);
		
		//String uploadDir = "user-photos/"+savedSwimmer.getId();
		
		////FileUploadUtil.saveFile(path, fileName, multipartFile);
		try {
			FileUploadUtil.saveFile(path, fileName, multipartFile);
			swimmer.setPhotos(fileName);
			swimmer = swimmerService.updateSwimmer(swimmer);
		}catch (IOException e) {
			e.printStackTrace();
			return "redirect:/competitions/swimmers?error=Please try again!";
		}
		return "redirect:/competitions/swimmers";
	}
}
