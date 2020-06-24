package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
//	@Autowired
//	private PrincipalDetail principal;
//	
	@GetMapping({ "", "/" })
	//@AuthenticationPrincipal PrincipalDetail principal
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤로에서 시큐리티 세션을 어떻게 찾는지??
//	public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤로에서 시큐리티 세션을 어떻게 찾는지??	
		// setting base dir
		// /WEB-INF/views/
		System.out.println("login user id:" + principal.getUsername());
		return "index";
	}
}
