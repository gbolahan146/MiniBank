package com.banking.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

	
	@GetMapping("/admin/home")
	public String adminhome() {
		return "admin/home";
	}
	
}
