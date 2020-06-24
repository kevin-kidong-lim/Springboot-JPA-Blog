package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
//	
//	@Autowired
//	private  HttpSession session;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		// db insert
		user.setRole(RoleType.USER);
		userService.save(user);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

//	// 전통적인 로그인 방식 
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user) {
////	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		// db insert 
//		System.out.println("UserApiController: login call");
//		User principal = userService.login(user); //접근 주체 principal
//		
//		if(principal != null) {
//			session.setAttribute("principal",  principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}

//	// 스프링 시큐리티 로그인 방식 .
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
////	public ResponseDto<Integer> login(@RequestBody User user) { // 위에다가 private 선언을 해서 사용 가능 .
//		// db insert 
//		System.out.println("UserApiController: login call");
//		User principal = userService.login(user); //접근 주체 principal
//		
//		if(principal != null) {
//			session.setAttribute("principal",  principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}
