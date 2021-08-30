/* this controller is for routing only */
package com.recordManagement.Java_assesment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recordManagement.Java_assesment.model.EmailEntity;
import com.recordManagement.Java_assesment.servicesImpl.SendMailServiceImpl;

@Controller
public class MainController {
	@Autowired
	private SendMailServiceImpl mailService;
	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/contact")
	public String contact(Model model, @RequestParam(name = "error" , required = false) boolean error) {
		EmailEntity email = new EmailEntity();
		model.addAttribute("email",email);
		model.addAttribute("error",error);
		return "contact";
	}
	@PostMapping("/sendMail")
	public String sendMail(@Valid @ModelAttribute("email") EmailEntity email, Model model) {
		EmailEntity emailSent =  mailService.SendMai(email);
		return contact(model, !emailSent.isSent());
	}
}
