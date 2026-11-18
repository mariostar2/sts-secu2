package com.green.study4.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	

	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "/admin/dashboard";
	}
}
