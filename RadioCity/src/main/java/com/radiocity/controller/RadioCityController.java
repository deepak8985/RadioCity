package com.radiocity.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.radiocity.dao.UserDao;

@Controller
public class RadioCityController {

	@Autowired
	UserDao userss;

	@PostMapping(value="/page")
	public ModelAndView fristPage(@RequestParam("file")@Autowired MultipartFile multipart) throws IOException {
		    File convFile = new File( multipart.getOriginalFilename());
		    multipart.transferTo(convFile);
	        userss.saveUser(convFile);
		    return new ModelAndView("page");
	}
	
	@GetMapping(value="/page1")
	public ModelAndView fristPage() {
		return new ModelAndView("page");
	}
}
