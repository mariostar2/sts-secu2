package com.green.study4.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.study4.dto.UserDto;
import com.green.study4.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@PreAuthorize("hasAnyRole('MEMBER','ADMIN')")
@RequiredArgsConstructor
public class MemberController {
	private final UserService userService;
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping("/mem01")
	public String mem01() {
		return "member/mem01";
	}
	
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/p1")
	public String p1() {
		return "p1";
	}

	@GetMapping("/join")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/join")
	public String join(UserDto user) {
		userService.regist(user);
		return "redirect:/";
	}
}
